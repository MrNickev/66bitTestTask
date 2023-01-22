const search = document.getElementById('club');
const list = document.getElementById('search-list');
const options = list.children;
const countries = document.getElementById('country').children;

for (let i = 1, n = options.length; i < n; i++) {
    let option = options[i];

    option.addEventListener('click', (e) => {
        search.value = e.target.textContent;
    })
}
if (selectedCountry !== null && selectedClub !== null) {
    console.log(selectedCountry);
    console.log(selectedClub);

    for (let i = 1, n = options.length; i < n; i++) {
        let option = options[i];
        if (option.textContent === selectedClub) {
            option.selected = true;
            search.value = option.textContent;
        }
    }

    for (let i = 1, n = countries.length; i < n; i++) {
        let option = countries[i];
        if (option.textContent === selectedCountry) {
            option.selected = true;
        }
    }
}


// При фокусе инпута показывает писок
search.addEventListener('focus', (e) => {
    searchFromInput(e.target.value);
});

// При расфокусировать инпута скрываем select
search.addEventListener('focusout', () => {
    changeSelectSize(1);
});

// Добавляем эвент при нажатия на клавиши
search.addEventListener('keyup', (e) => {
    searchFromInput(e.target.value);
})

function changeSelectSize(size) {
    setTimeout(() => {
        list.size = size;
    }, 75);
}

// Проходим по каждому элементу списка
function searchFromInput(value) {
    let size = 5;

    for (let i = 1, n = options.length; i < n; i++) {
        let option = options[i];

        // Если текст элемента содержит наше строку то показываем её, в противоположном слкчае скрываем
        if (option.textContent.toLowerCase().includes(value.toLowerCase())) {
            option.hidden = false;
            size++;
        } else {
            option.hidden = true;
        }
        changeSelectSize(size);
    }
}