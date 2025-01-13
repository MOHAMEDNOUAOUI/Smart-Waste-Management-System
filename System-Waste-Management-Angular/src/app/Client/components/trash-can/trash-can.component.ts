import { Component, AfterViewInit, ElementRef } from '@angular/core';
import * as THREE from 'three';
import { GLTFLoader } from 'three/examples/jsm/loaders/GLTFLoader.js';

@Component({
  selector: 'app-trashcan',
  standalone: true,
  templateUrl: './trash-can.component.html',
  styleUrls: ['./trash-can.component.css']
})
export class TrashCanComponent implements AfterViewInit {
  private container!: HTMLElement;
  private scene!: THREE.Scene;
  private camera!: THREE.PerspectiveCamera;
  private renderer!: THREE.WebGLRenderer;
  private loader!: GLTFLoader;
  private trashCan!: THREE.Object3D;

  constructor(private el: ElementRef) {}

  ngAfterViewInit(): void {
    this.container = this.el.nativeElement.querySelector('#three-container')!;
    this.initScene();
    this.loadModel();
  }

  private initScene(): void {
    this.scene = new THREE.Scene();
    this.scene.background = null;  // Remove background color

    this.camera = new THREE.PerspectiveCamera(
      75,
      this.container.offsetWidth / this.container.offsetHeight,
      0.1,
      1000
    );
    this.camera.position.set(0, 1, 5);

    this.renderer = new THREE.WebGLRenderer({ antialias: true, alpha: true }); // alpha for transparency
    this.renderer.setSize(this.container.offsetWidth, this.container.offsetHeight);
    this.container.appendChild(this.renderer.domElement);

    const ambientLight = new THREE.AmbientLight(0xffffff, 0.5);
    this.scene.add(ambientLight);

    const directionalLight = new THREE.DirectionalLight(0xffffff, 1);
    directionalLight.position.set(0, 5, 5);
    this.scene.add(directionalLight);
  }

  private loadModel(): void {
    this.loader = new GLTFLoader();
    const modelPath = '/models/trash_can.glb';

    this.loader.load(
      modelPath,
      (gltf) => {
        console.log('Model loaded:', gltf);
        this.trashCan = gltf.scene;
        this.trashCan.scale.set(0.5, 0.5, 0.5); 
        this.trashCan.position.set(0, -1, -3);
        this.scene.add(this.trashCan);
      },
      (progress) => {
        console.log(`Loading: ${Math.round((progress.loaded / progress.total) * 100)}%`);
      },
      (error) => {
        console.error('An error occurred loading the model:', error);
      }
    );
  }

  private animate(): void {
    requestAnimationFrame(() => this.animate());

    this.renderer.render(this.scene, this.camera);
  }
}
