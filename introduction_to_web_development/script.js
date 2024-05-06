document.querySelector("p").addEventListener("click", (e) => {
    const name = prompt("What's your name?");
  
    e.target.innerText = `Hello, ${name}!`;
  });