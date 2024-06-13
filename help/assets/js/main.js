// chay slider theo time dinh san
var slides = document.querySelectorAll('.banner');
let i = 0;
setInterval(function(){ 

    slides.forEach( (slide, i) => {
      slide.style.display = 'none';
    })
  
    if( i == slides.length) {
      i = 0; 
    }
    
    slides[i].style.display = 'flex';
    
    i++;
  
  }, 2000);


// show modal
var userE = document.getElementById("navbar__user");
var userBlueE = document.getElementById("navbar__user--blue");
var closeBtn = document.querySelector('.modal__close');
console.log(userE);
var modalE = document.getElementById("modal");

function showModal() {
    modalE.classList.add("open");
}

function hiddenModal() {
  modalE.classList.remove("open");
}

userE.addEventListener("click", showModal);
userBlueE.addEventListener("click", showModal);
closeBtn.addEventListener("click", hiddenModal);

modalE.addEventListener('click', hiddenModal);

var modalContainerE = document.querySelector('#modal__container');

modalContainerE.addEventListener('click', function(e) {
      e.stopPropagation();
})

//an hien dang ky/ dang nhap
var registerBtn = document.querySelector('.register-btn');
var loginBtn = document.querySelector('.login-btn');
var registerE = document.querySelector('.register-form');
var loginE = document.querySelector('.login-form');
console.log(registerBtn)
console.log(loginBtn)
// console.log(modalContainerE);

function showRegisForm() {
  loginE.classList.remove("open");
  registerE.classList.add("open");
}

function showLoginForm() {
  registerE.classList.remove("open");
  loginE.classList.add("open");
}

registerBtn.onclick = function() {
  showRegisForm();
  return false;
}

loginBtn.onclick = function() {
  showLoginForm();
  return false;
}



// thay doi header
var headerE = document.querySelector('.header');
console.log(headerE)
var headerBlueE = document.querySelector('.header--blue');
console.log(headerBlueE)

window.onscroll = function() {
  if(document.documentElement.scrollTop > 0) {
    headerBlueE.style.display = "none";
    headerE.style.display = "flex";
}else {
    headerBlueE.style.display = "flex";
    headerE.style.display = "none";
}
};

