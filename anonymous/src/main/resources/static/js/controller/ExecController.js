class ExecController {


	constructor() {
		this.columns = [
			{ name: 'status', label: 'Status', type: 'text', required: false },
			{ name: 'scheduleStart', label: 'Schedule Start', type: 'text', required: false },
			{ name: 'jobStart', label: 'Job Start', type: 'text', required: false },
			{ name: 'rootPid', label: 'Rott Pid', type: 'text', required: false },
			{ name: 'countTry', label: 'Try', type: 'text', required: false },
			{ name: 'agent', label: 'Agent', type: 'text', required: false },
			{ name: 'taskGroup', label: 'Task Group', type: 'text', required: false },
			{ name: 'pid', label: 'Pid', type: 'text', required: false },
			{ name: 'confId', label: 'Conf Id', type: 'text', required: false },
			{ name: 'taskOrder', label: 'Order', type: 'text', required: false },
			{ name: 'subTaskGroup', label: 'Sub Task', type: 'text', required: false },
			{ name: 'subTaskGroupLevel', label: 'Sub Task Level', type: 'text', required: false },
			{ name: 'loopNum', label: 'Loop', type: 'text', required: false },
			{ name: 'instance', label: 'Instance', type: 'text', required: false },
			{ name: 'criticalJob', label: 'Critical', type: 'text', required: false },
			{ name: 'linuxRunTimeId', label: 'Linux PID', type: 'text', required: false },
			{ name: 'linuxLog', label: 'Log', type: 'text', required: false }
			// Add more columns as needed
		];


		this.apiUrl = '/restExec'; // Replace with your API endpoint
		this.grid = document.getElementById('grid');
		this.gridBody = document.getElementById('gridBody');
		this.editForm = document.getElementById('editForm');
		this.itemForm = document.getElementById('itemForm');
		this.itemForm.addEventListener('submit', this.updateItem.bind(this));

		this.fetchData();
	}

	createColumns() {
		const headerRow = document.getElementById('headerRow');

		
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
		const statusFilter = document.getElementById('status').value.trim();

		const url = `${this.apiUrl}?taskName=${processFilter}&instance=${instanceFilter}&status=${statusFilter}`;

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
				else if (column.name == 'status'){
					
					let statusDesc='';
					
					switch (item[column.name]) {
							  case '1':
							    statusDesc = 'Scheduled';
							    cell.style = "font-weight: bold";
							    break;
							  case '2':
							    statusDesc = 'Executing';
							    cell.style = "font-weight: bold";
							    break;
							  case '3':
							     statusDesc = 'Success';
							     cell.style = "color:green; font-weight: bold";
							    break;
							  case '4':
							    statusDesc = 'Error';
							    cell.style = "color:red; font-weight: bold";
							    break;
							  case '5':
								  statusDesc = 'Timeout';
								  cell.style = "color:red; font-weight: bold";
	  					}
	  					cell.textContent = statusDesc;
	  					
						
				}
				else {
					cell.textContent = item[column.name];
				}


				cell.value = item[column.name];
				cell.id = column.name + counter;
				cell.classList.add('px-6');
				cell.classList.add('py-4');
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
			status: document.getElementById('status' + itemId).value,
			scheduleStart: document.getElementById('scheduleStart' + itemId).value,
			jobStart: document.getElementById('jobStart' + itemId).value,
			rootPid: document.getElementById('rootPid' + itemId).value,
			countTry: document.getElementById('countTry' + itemId).value,
			agent: document.getElementById('agent' + itemId).value,
			taskGroup: document.getElementById('taskGroup' + itemId).value,
			pid: document.getElementById('pid' + itemId).value,
			confId: document.getElementById('confId' + itemId).value,
			taskOrder: document.getElementById('taskOrder' + itemId).value,
			subTaskGroup: document.getElementById('subTaskGroup' + itemId).value,
			subTaskGroupLevel: document.getElementById('subTaskGroupLevel' + itemId).value,
			loopNum: document.getElementById('loopNum' + itemId).value,
			instance: document.getElementById('instance' + itemId).value,
			criticalJob: document.getElementById('criticalJob' + itemId).value,
			linuxRunTimeId: document.getElementById('linuxRunTimeId' + itemId).value,
			linuxLog: document.getElementById('linuxLog' + itemId).value
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
			.then(response => {                      // first then()
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
