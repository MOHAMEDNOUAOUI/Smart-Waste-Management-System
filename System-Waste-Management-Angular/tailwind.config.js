/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {
      boxShadow: {
        green: '0 4px 6px rgba(34, 197, 94, 0.5)',
      },
      colors: {
        backgroundColor: '#22e55a'
      },
      backgroundImage:{
        'Gradiant' : 'linear-gradient(180deg, rgb(125, 250, 125) 0%, rgb(30, 161, 30) 100%)',
      }
    },
  },
  plugins: [],
}

