const startScreen = document.getElementById("start-screen");
const quizContainer = document.getElementById("quiz-container");
const resultContainer = document.getElementById("result-container");
const questionElement = document.getElementById("question");
const optionsContainer = document.getElementById("options");
const timerElement = document.getElementById("time");
const scoreElement = document.getElementById("score");
const startButton = document.getElementById("start-btn");
const restartButton = document.getElementById("restart-btn");

let questions = [];
let currentQuestionIndex = 0;
let score = 0;
let timeLeft = 15;
let timer;

async function fetchQuestions(category, difficulty) {

    const url = `https://opentdb.com/api.php?amount=5&category=${category}&difficulty=${difficulty}&type=multiple`;
    const response = await fetch(url);
    const data = await response.json();
    return data.results;
}

function startQuiz() {
    const category = document.getElementById("category").value;
    const difficulty = document.getElementById("difficulty").value;

    fetchQuestions(category, difficulty).then((data) => {
        questions = data;
        currentQuestionIndex = 0;
        score = 0;
        startScreen.classList.add("hidden");
        quizContainer.classList.remove("hidden");
        showQuestion();
    });
}

function showQuestion() {
    if (currentQuestionIndex >= questions.length) {
        endQuiz();
        return;
    }

    const questionData = questions[currentQuestionIndex];
    questionElement.innerHTML = `${currentQuestionIndex+1}.`+questionData.question;
    optionsContainer.innerHTML = "";

    let answers = [...questionData.incorrect_answers, questionData.correct_answer];
    answers.sort(() => Math.random() - 0.5);

    answers.forEach((answer) => {
        const button = document.createElement("button");
        button.textContent = answer;
        button.onclick = () => checkAnswer(answer, questionData.correct_answer,button);
        optionsContainer.appendChild(button);
    });

    startTimer();
}

function startTimer() {
    timeLeft = 15;
    timerElement.textContent = timeLeft;

    clearInterval(timer);
    timer = setInterval(() => {
        timeLeft--;
        timerElement.textContent = timeLeft;
        if (timeLeft <= 0) {
            clearInterval(timer);
            showCorrectAnswer();
        }
    }, 1000);
}

function checkAnswer(selectedAnswer, correctAnswer, button) {
    clearInterval(timer);
    if (selectedAnswer === correctAnswer) {
        score++;
        button.classList.add("correct");
        setTimeout(() => {
            currentQuestionIndex++;
            showQuestion();
        }, 2000);
    }
    else{
        button.classList.add("wrong");
        showCorrectAnswer();
    }
}

function showCorrectAnswer() {
    document.querySelectorAll("#options button").forEach((button) => {
        if (button.textContent === questions[currentQuestionIndex].correct_answer) {
            button.classList.add("correct");
        } 
    });

    setTimeout(() => {
        currentQuestionIndex++;
        showQuestion();
    }, 2000);
}

function endQuiz() {
    quizContainer.classList.add("hidden");
    resultContainer.classList.remove("hidden");
    scoreElement.textContent = score;
}

startButton.addEventListener("click", startQuiz);
restartButton.addEventListener("click", () => {
    resultContainer.classList.add("hidden");
    startScreen.classList.remove("hidden");
});

