"use strict";

const labelMessage = document.querySelector(".message");
const btnConvert = document.querySelector(".btn-convert");
const inputNumber = document.querySelector(".find-input");
const bodyBackground = document.querySelector("body");

let input, inWords;

const init = function () {
  labelMessage.textContent = "START ENTERING THE NUMBER";
  bodyBackground.style.backgroundColor = "black";
  console.log("This is a init function");

  inWords = "";
  inputNumber.value = "";
};

init();

const converEvent = function () {
  input = Number(inputNumber.value);

  if (!input) {
    inWords = "The Input Box is empty";
    bodyBackground.style.backgroundColor = "red";
  }

  // console.log(input);
  else {
    switch (input) {
      case 0:
        inWords = "ZERO";
        break;
      case 1:
        inWords = "ONE";
        break;
      case 2:
        inWords = "TWO";
        break;
      case 3:
        inWords = "THREE";
        break;
      case 4:
        inWords = "FOUR";
        break;
      case 5:
        inWords = "FIVE";
        break;
      case 6:
        inWords = "SIX";
        break;
      case 7:
        inWords = "SEVEN";
        break;
      case 8:
        inWords = "EIGHT";
        break;
      case 9:
        inWords = "NINE";
        break;
      default:
        inWords = "Enter a Number Between 0 to 9 ";
        break;
    }
    console.log(inWords);
    labelMessage.textContent = inWords;
    if (input < 10 && input) bodyBackground.style.backgroundColor = "green";
    else bodyBackground.style.backgroundColor = "red";
  }
};

btnConvert.addEventListener("click", converEvent);

bodyBackground.addEventListener("keydown", function () {
  if (event.key === "Enter") {
    converEvent();
  } else if (event.keyCode === 27) {
    init();
  }
});
