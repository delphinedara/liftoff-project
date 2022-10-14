let stars = document.querySelectorAll(".stars a");

stars.forEach((star, idx )=>{
    star.addEventListener("click", () =>{
        console.log(`star of index ${idx + 1} was clicked`);
    })
});