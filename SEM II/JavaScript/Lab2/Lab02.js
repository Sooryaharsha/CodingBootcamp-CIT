console.log("Hello world!");

const inputBox = document.querySelector(".find-input");
const btnFind = document.querySelector(".btn-find");
const messageBox = document.querySelector(".message");
const body = document.querySelector(".body");
console.log(inputBox.value);

const todaysDate = new Date();

let daysLeft = 0;

btnFind.addEventListener("click", function () {
  console.log(todaysDate);
  console.log(inputBox.value);

  const bdateArray = inputBox.value.split("-");
  console.log(todaysDate.getFullYear());

  const userBdayDate = Number(bdateArray[2]);
  const userBdayMonth = Number(bdateArray[1]) - 1;
  let year;
  const currentYear = todaysDate.getFullYear();

  if (userBdayMonth > todaysDate.getMonth()) {
    year = currentYear;
  } else if (userBdayMonth === todaysDate.getMonth()) {
    if (userBdayDate < todaysDate.getDate()) year = currentYear + 1;
    else year = currentYear;
  } else year = currentYear + 1;

  console.log(year);
  const nextBday = new Date(year, userBdayMonth, userBdayDate);
  console.log(nextBday);
  daysLeft = Math.ceil((nextBday - todaysDate) / 86400000);
  console.log(daysLeft);

  body.style.background = "linear-gradient(to top left, #28b487, #7dd56f)";
  messageBox.textContent = `${daysLeft} days left for Your Birthday 😍`;
});


