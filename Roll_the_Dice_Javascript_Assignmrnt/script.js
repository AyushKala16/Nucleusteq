let player1Score = 0;
let player2Score = 0;
let player1Current = 0;
let player2Current = 0;
let activePlayer = 1;

const rollDiceBtn = document.getElementById("roll-dice");
const saveScoreBtn = document.getElementById("save-score");
const resetGameBtn = document.getElementById("reset-game");

const diceImage = document.getElementById("dice-image");
const winnerMessage = document.getElementById("winner-message");

function rollDice() {
    let diceValue = Math.floor(Math.random() * 6) + 1;
    // Add shake effect
    diceImage.classList.add("shake");

    // Wait for the animation to complete before changing the dice image
    setTimeout(() => {
        diceImage.src = `./util/dice${diceValue}.png`;
        diceImage.classList.remove("shake"); // Remove shake effect after animation
    }, 500);

    if (activePlayer === 1) {
        if (diceValue === 1) {
            player1Current = 0;
            switchTurn();
        } else {
            player1Current += diceValue;
        }
        document.getElementById("player1-current").textContent = player1Current;
    } else {
        if (diceValue === 1) {
            player2Current = 0;
            switchTurn();
        } else {
            player2Current += diceValue;
        }
        document.getElementById("player2-current").textContent = player2Current;
    }
}


function saveScore() {
    if (activePlayer === 1) {
        player1Score += player1Current;
        player1Current = 0;
        document.getElementById("player1-score").textContent = player1Score;
        document.getElementById("player1-current").textContent = player1Current;
        if (player1Score >= 100) {
            declareWinner(document.getElementById("player1-name").value);
            return;
        }
    } else {
        player2Score += player2Current;
        player2Current = 0;
        document.getElementById("player2-score").textContent = player2Score;
        document.getElementById("player2-current").textContent = player2Current;
        if (player2Score >= 100) {
            declareWinner(document.getElementById("player2-name").value);
            return;
        }
    }
    switchTurn();
}

function switchTurn() {
    activePlayer = activePlayer === 1 ? 2 : 1;
}

function declareWinner(playerName) {
    winnerMessage.textContent = `${playerName} Wins!`;
    rollDiceBtn.disabled = true;
    saveScoreBtn.disabled = true;
}

function resetGame() {
    player1Score = 0;
    player2Score = 0;
    player1Current = 0;
    player2Current = 0;
    activePlayer = 1;

    document.getElementById("player1-score").textContent = player1Score;
    document.getElementById("player2-score").textContent = player2Score;
    document.getElementById("player1-current").textContent = player1Current;
    document.getElementById("player2-current").textContent = player2Current;
    diceImage.src = "./util/dice1.png";
    winnerMessage.textContent = "";
    rollDiceBtn.disabled = false;
    saveScoreBtn.disabled = false;
}

rollDiceBtn.addEventListener("click", rollDice);
saveScoreBtn.addEventListener("click", saveScore);
resetGameBtn.addEventListener("click", resetGame);
