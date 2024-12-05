/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {
      boxShadow: {
        green: '0 4px 6px rgba(34, 197, 94, 0.5)',
      }
    },
  },
  plugins: [],
}

