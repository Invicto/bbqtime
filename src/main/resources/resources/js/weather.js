document.addEventListener('DOMContentLoaded', () => {

  document.querySelector('form').addEventListener('submit', event => {
    event.preventDefault()
    console.log('submit')
  })

  const inputFieldLat = document.querySelector('input[type="text", id="lat"]')
  const inputFieldLon = document.querySelector('input[type="text", id="lon"]')

