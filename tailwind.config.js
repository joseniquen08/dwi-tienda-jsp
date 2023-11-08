/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/main/webapp/**/*.{html,jsp,js}"],
  theme: {
    extend: {
		fontFamily: {
			'poppins': "Poppins, sans-serif",
		},
	},
  },
  plugins: [],
}

