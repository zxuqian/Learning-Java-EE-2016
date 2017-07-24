function handleEvent(event) {
    console.log(event)
}

function toggleRegistrationForm() {
    var regForm = document.getElementById('registrationForm')
    regForm.classList.toggle('hide')
    return false
}