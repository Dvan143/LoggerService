const answer = document.getElementById('logs')

function fetchLogs() {
    const page = document.getElementById('page').value
    fetch(`/api/getLogs?page=${page}`)
        .then(resp => {
            if(resp.status!==200) {
                answer.innerText='Api error'
                return;
            }
            return resp.json();
        }).then(resp => {
            renderLogs(resp)
    })
}
function renderLogs(resp) {
    const ul = document.createElement('ul');
    resp.forEach(resp => {
        const li = document.createElement('li');
        const div = document.createElement('div');
        div.innerHTML=`
            <div>Date: ${resp.date}</div>
            <div>${resp.body}</div>
            <div>${resp.additionalInfo}</div>
            <div>By: ${resp.from}</div>
        `
        li.appendChild(div);
        ul.appendChild(li)
    })
    ul.innerHTML=``;
    answer.appendChild(ul);
}