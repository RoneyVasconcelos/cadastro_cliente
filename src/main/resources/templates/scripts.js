document.getElementById('livrosBtn').addEventListener('click', function() {
    fetch('https://cadastro-livros.onrender.com/biblioteca/pesquisar_livro/')
        .then(response => response.json())
        .then(data => {
            const livrosLista = document.getElementById('livrosLista');
            livrosLista.innerHTML = '<h2>Lista de Livros</h2>';

            if (data.length === 0) {
                livrosLista.innerHTML += '<p>Nenhum livro cadastrado.</p>';
            } else {
                const list = document.createElement('ul');
                data.forEach(livro => {
                    const listItem = document.createElement('li');
                    listItem.textContent = `${livro.titulo} - ${livro.autor}`;
                    list.appendChild(listItem);
                });
                livrosLista.appendChild(list);
            }
        })
        .catch(error => {
            console.error('Erro ao buscar livros:', error);
        });
});
