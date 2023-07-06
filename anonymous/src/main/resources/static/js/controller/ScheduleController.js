class ScheduleController {

	constructor() {
		this.columns = [
			{ name: 'scheduleId', label: 'Schedule Id', type: 'text', required: true, editform: true },
			{ name: 'taskGroup', label: 'Task Group', type: 'text', required: true, editform: true },
			{ name: 'instance', label: 'Instance', type: 'text', required: true, editform: true },			
			{ name: 'scheduleType', label: 'Schedule Type', type: 'select', required: true, editform: true },
			{ name: 'scheduleValue', label: 'Schedule Value', type: 'text', required: true, editform: true },
			{ name: 'lastSchedule', label: 'Last Schedule', type: 'text', required: false, editform: true },
			{ name: 'agent', label: 'Agent', type: 'text', required: true, editform: true },
			{ name: 'validFrom', label: 'Valid from', type: 'text', required: true, editform: true },
			{ name: 'validTo', label: 'Valid to', type: 'text', required: true, editform: true },
			{ name: 'status', label: 'Status', type: 'text', required: true, editform: true },
			{ name: 'criticalJob', label: 'Critical', type: 'text', required: false, editform: true },
			{ name: 'numberAttempts', label: 'Attempts', type: 'text', required: false, editform: true },
			{ name: 'prmt1', label: 'PRMT1', type: 'text', required: false, editform: true },
			{ name: 'executing', label: 'executing', type: 'text', required: false, editform: false }

			// Add more columns as needed
		];


		this.apiUrl = '/restSchedule'; // Replace with your API endpoint
		this.grid = document.getElementById('grid');
		this.gridBody = document.getElementById('gridBody');
		this.editForm = document.getElementById('editForm');
		this.itemForm = document.getElementById('itemForm');
		this.itemForm.addEventListener('submit', this.updateItem.bind(this));

		this.fetchData();
	}

	createColumns() {
		const headerRow = document.getElementById('headerRow');
		
		const addBtn = document.createElement('button');
		addBtn.classList.add('gg-add');
		addBtn.addEventListener('click', this.newRow.bind(this));
		
		const th = document.createElement('th');
		th.classList.add('px-6');
		th.classList.add('py-3');
		th.scope = 'scope="col"';
		th.textContent = '';
		th.appendChild(addBtn);
		headerRow.appendChild(th);

		
		for (const column of this.columns) {
			const th = document.createElement('th');
			th.classList.add('px-6');
			th.classList.add('py-3');
			th.scope = 'scope="col"';
			th.textContent = column.label;
			headerRow.appendChild(th);
		}
	}

	fetchData() {
		const processFilter = document.getElementById('process').value.trim();
		const instanceFilter = document.getElementById('instance').value.trim();

		const url = `${this.apiUrl}?taskGroup=${processFilter}&instance=${instanceFilter}`;

		fetch(url)
			.then(response => response.json())
			.then(data => this.displayData(data))
			.catch(error => console.error('Error:', error));
	}

	displayData(data) {

		let counter = 0;
		this.gridBody.innerHTML = '';

		for (const item of data) {

			const row = document.createElement('tr');
			row.classList.add('bg-white');
			row.classList.add('border-b');
			row.classList.add('dark:bg-gray-800');
			row.classList.add('dark:border-gray-700');
			
			const actionsCell = document.createElement('td');
			actionsCell.classList.add('flex');
			actionsCell.classList.add('space-x-4');
			actionsCell.classList.add('mt-5');
			actionsCell.classList.add('px-6');
			actionsCell.classList.add('py-4');			

			const editBtn = document.createElement('button');
			editBtn.classList.add('gg-pen');
			editBtn.dataset.itemId = counter;
			editBtn.addEventListener('click', this.editRow.bind(this));
			actionsCell.appendChild(editBtn);

			const deleteBtn = document.createElement('button');
			deleteBtn.dataset.itemId = counter;
			deleteBtn.classList.add('gg-trash');

			deleteBtn.addEventListener('click', this.deleteRow.bind(this));

			actionsCell.appendChild(deleteBtn);
			
			row.appendChild(actionsCell);


			for (const column of this.columns) {
				const cell = document.createElement('td');


				if (column.type == 'timestamp' && item[column.name] != null) {
					let date = new Date(item[column.name]);
					if (date.getHours() == 0 && date.getMinutes() == 0) {
						cell.textContent = '' + date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear();
					} else {
						cell.textContent = '' + date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear() + ' ' + date.getHours() + ':' + date.getMinutes();
					}
				}
				else {
					cell.textContent = item[column.name];
				}


				cell.value = item[column.name];
				cell.id = column.name + counter;
				cell.classList.add('px-6');
				cell.classList.add('py-4');
				
				console.log(item['executing']);
				
				if (item['executing'] == 'Y'){
					console.log('entrou aqui');
					row.classList.add('bg-red');
				}
				row.appendChild(cell);
			}


			this.gridBody.appendChild(row);

			counter++;
		}
	}

	editRow(event) {


		const itemId = event.target.dataset.itemId;
		const item = this.getItemById(itemId);
		if (item) {
			this.showEditForm(item);
		}

	}

	newRow(event) {
		const item = {};
		this.showEditForm(item);
	}


	getItemById(itemId) {

		const item = {
			taskGroup: document.getElementById('taskGroup' + itemId).value,
			instance: document.getElementById('instance' + itemId).value,
			scheduleId: document.getElementById('scheduleId' + itemId).value,
			scheduleType: document.getElementById('scheduleType' + itemId).value,
			scheduleValue: document.getElementById('scheduleValue' + itemId).value,
			lastSchedule: document.getElementById('lastSchedule' + itemId).value,
			agent: document.getElementById('agent' + itemId).value,
			validFrom: document.getElementById('validFrom' + itemId).value,
			validTo: document.getElementById('validTo' + itemId).value,
			status: document.getElementById('status' + itemId).value,
			criticalJob: document.getElementById('criticalJob' + itemId).value,
			numberAttempts: document.getElementById('numberAttempts' + itemId).value,
			prmt1: document.getElementById('prmt1' + itemId).value,
		};
		
		return item;
	}

	showEditForm(item) {
		this.itemForm.reset();

		const formFields = document.getElementById('formFields');
		formFields.innerHTML = '';

		for (const column of this.columns) {
			
			const label = document.createElement('label');
			label.textContent = column.label;

			if (column.editform && column.type == 'text') {
				
				const input = document.createElement('input');
				input.type = 'text';
	
				input.classList.add('border');
				input.classList.add('border-gray-400');
				input.classList.add('block');
				input.classList.add('py-2');
				input.classList.add('px-4');
				input.classList.add('w-full');
				input.classList.add('rounded');
				input.classList.add('focus:outline-none');
				input.classList.add('focus:border-orange-500');
				input.required = column.required;
				input.name = column.name;
				input.id = column.name + 'Edit';
				if (Object.keys(item).length != 0) {
					input.value = item[column.name];
				}
	
				formFields.appendChild(label);
				formFields.appendChild(input);
				
			}
			
			if (column.editform && column.type == 'select'){
					
					const types = ['DAILY','WEEK','MONTH','YEAR','QUARTER','SEMESTER','DAY','BIWEEKLY','BUSINESSDAY'];
				
					const selectList = document.createElement("select");
					
					for (let i = 0; i < types.length; i++) {
					    var option = document.createElement("option");
					    option.value = types[i];
					    option.text = types[i];
					    selectList.appendChild(option);
					}
							
					selectList.classList.add('border');
					selectList.classList.add('border-gray-400');
					selectList.classList.add('block');
					selectList.classList.add('py-2');
					selectList.classList.add('px-4');
					selectList.classList.add('w-full');
					selectList.classList.add('rounded');
					selectList.classList.add('focus:outline-none');
					selectList.classList.add('focus:border-orange-500');
					selectList.name = column.name;
					
					selectList.id = column.name + 'Edit';
					selectList.value = item[column.name];
					formFields.appendChild(label);
					formFields.appendChild(selectList);				 
					
			}
			


		}

		this.editForm.style.display = 'block';
		document.getElementById('saveBtn').focus();
	}

	updateItem(event) {
		event.preventDefault();

		const formData = new FormData(this.itemForm);
		const data = {};

		for (const [name, value] of formData.entries()) {
			data[name] = value;
		}

		console.log(JSON.stringify(data));

		fetch(this.apiUrl, {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(data)
		})
			.then(response => {
				if (!response.ok) {
					return response.text().then(text => { throw new Error(text) })
				}
				alert('Saved with sucess!');
				return response.json();
			})
			.then(updatedItem => {
				this.hideEditForm();
				this.fetchData();
			})
			.catch(error => {
				alert('Error: ' + error);
				this.hideEditForm();
			});
	}

	deleteRow(event) {

		const itemId = event.target.dataset.itemId;
		const item = this.getItemById(itemId);

		if (confirm('Are you sure you want to delete this item?')) {

			fetch(this.apiUrl, {
				method: 'DELETE',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(item)
			})
				.then(response => {
					console.log('Deleted item:', itemId);
					this.fetchData();
				})
				.catch(error => alert('Error: ' + error));
		}
	}

	hideEditForm() {
		this.editForm.style.display = 'none';
	}
}
