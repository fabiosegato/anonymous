class ControlController {


	constructor() {
		this.columns = [
			{ name: 'process', label: 'Process', type: 'text', required: true },
			{ name: 'dateReference', label: 'Date reference', type: 'timestamp', required: true },
			{ name: 'seqId', label: 'Seq ID', type: 'text', required: true },
			{ name: 'institutionNumber', label: 'Institution', type: 'text', required: true },
			{ name: 'scheduleType', label: 'Schedule Type', type: 'text', required: true },
			{ name: 'businessday', label: 'Business Day', type: 'text', required: false },
			{ name: 'prmt1', label: 'PRMT 1', type: 'text', required: false },
			{ name: 'daysQtd', label: 'Day´s Quantity', type: 'text', required: true }
			// Add more columns as needed
		];


		this.apiUrl = ' http://localhost:8080/restControl'; // Replace with your API endpoint
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

		const addBtn = document.createElement('button');
		addBtn.classList.add('gg-add');
		//addBtn.dataset.itemId = counter;
		addBtn.addEventListener('click', this.newRow.bind(this));


		const th = document.createElement('th');
		th.class = 'class="px-6 py-3"';
		th.scope = 'scope="col"';
		th.textContent = '';
		th.appendChild(addBtn);
		headerRow.appendChild(th);
	}

	fetchData() {
		const processFilter = document.getElementById('process').value.trim();
		const institutionFilter = document.getElementById('institution').value.trim();
		const dateReferenceFilter = document.getElementById('dateReference').value.trim();

		const url = `${this.apiUrl}?process=${processFilter}&institution=${institutionFilter}&dateReference=${dateReferenceFilter}`;

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
				else {
					cell.textContent = item[column.name];
				}


				cell.value = item[column.name];
				cell.id = column.name + counter;
				cell.classList.add('px-6');
				cell.classList.add('py-4');
				row.appendChild(cell);
			}

			const actionsCell = document.createElement('td');
			actionsCell.classList.add('flex');
			actionsCell.classList.add('space-x-4');
			actionsCell.classList.add('mt-5');
			actionsCell.classList.add('mr-5');

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
			process: document.getElementById('process' + itemId).value,			
			dateReference: document.getElementById('dateReference' + itemId).value,
			seqId: document.getElementById('seqId' + itemId).value,	
			institutionNumber: document.getElementById('institutionNumber' + itemId).value,
			scheduleType: document.getElementById('scheduleType' + itemId).value,
			businessday: document.getElementById('businessday' + itemId).value,
			prmt1: document.getElementById('prmt1' + itemId).value,
			daysQtd: document.getElementById('daysQtd' + itemId).value	

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
