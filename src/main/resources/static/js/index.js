const selectedTypeButton = document.querySelector(".selected-type-button");
const typeSelectBoxList = document.querySelector(".type-select-box-list");
const typeSelectBoxListLis = typeSelectBoxList.querySelectorAll("li");
const todoContentList = document.querySelector(".todo-content-list");
const sectionBody = document.querySelector(".section-body");

let page = 1;
let totalpage = 0;

sectionBody.onscroll = () =>{
	let checkNum = todoContentList.clientHeight - sectionBody.offsetHeight - sectionBody.scrollTop;
	
	if(checkNum < 1 && checkNum >-1 && page < totalpage){
	
		page++;
		load();
	}
}


let listType = "all";

load();

selectedTypeButton.onclick = () => {
    typeSelectBoxList.classList.toggle("visible");
}


function load(){
	$.ajax({
		type: "get",
		url: `/api/v1/todolist/list/${listType}`,
		data: {
			page: page,
			contentCount: 20
		},
		dataType: "json",
		success: (response) => {
			getList(response.data);
		},
		error: errorMessage	
	})
}

for(let i = 0; i < typeSelectBoxListLis.length; i++){
	
	typeSelectBoxListLis[i].onclick = () =>{
	page = 1;
	for(let i = 0; i < typeSelectBoxListLis.length; i++){
		if(typeSelectBoxListLis[i].classList.contains("type-selected")){
		typeSelectBoxListLis[i].classList.remove("type-selected");
		}
	}
	const selectedType = document.querySelector(".selected-type");
	
	typeSelectBoxListLis[i].classList.add("type-selected");
	
	listType = typeSelectBoxListLis[i].textContent.toLowerCase();
	
	selectedType.textContent = typeSelectBoxListLis[i].textContent;
	
	todoContentList.innerHTML = '';
	
	load();
	
	typeSelectBoxList.classList.toggle("visible");
		
	}
}

function setTotalCount(totalCount){
	totalpage = totalCount % 20 == 0 ? totalCount / 20 : Math.floor(totalCount / 20 + 1);
}

function getList(data) {
	const incompleteCountNumber = document.querySelector(".incomplete-count-number");
	incompleteCountNumber.textContent = data[0].incompleteCount;
	setTotalCount(data[0].totalCount)
	for(let content of data) {
		const listContent = `
			 <li class="todo-content">
                       <input type="checkbox" id="complete-check-${content.todoCode}" class="complete-check" ${content.todoComplete ? 'checked' : ''}>
                       <label for="complete-check-${content.todoCode}"></label>
                       <div class="todo-content-text">${content.todo}</div>
                       <input type="text" class="todo-content-input visible" value="${content.todo}">
                       <input type="checkbox" id="importance-check" class="importance-check" ${content.importance ? 'checked' : ''}>
                       <label for="importance-check-${content.todoCode}"></label>
                       <div class="trash-button"><i class="fa-solid fa-trash"></i></div>
                    </li>
		`
		
		todoContentList.innerHTML += listContent;
		document.querySelector(`#complete-check-${content.todoCode}`).checked = content.todoComplete;
		document.querySelector(`#complete-check-${content.todoCode}`).checked = content.importance;
	}

}


function errorMessage(request, status, error){
	alert("요청실패");
	console.log(request.status);
	console.log(request.responseText);
	console.log(error);
}