function rollDice() {
  const dice = [...document.querySelectorAll(".die-list")];
  var count1 = getRandomNumber(1, 6);
  toggleClasses(dice[0]);
  dice[0].dataset.roll = count1
 
  var count2 = 10;
  while (count1 + count2 > 10) {
    count2 = getRandomNumber(1, 6);
  };
  toggleClasses(dice[1]);
  dice[1].dataset.roll = count2;
}

function toggleClasses(die) {
  die.classList.toggle("odd-roll");
  die.classList.toggle("even-roll");
}

function getRandomNumber(min, max) {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

document.getElementById("roll-button").addEventListener("click", rollDice);
