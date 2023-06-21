class CommandsController {

	constructor() {

		this.columns = [
			{ name: 'id', label: 'Id', type: 'text', required: true },
			{ name: 'cmdGroup', label: 'Group', type: 'text', required: false },
			{ name: 'cmdOrder', label: 'Order', type: 'text', required: false },
			{ name: 'dsc', label: 'Desc', type: 'text', required: false },
			{ name: 'command', label: 'Command', type: 'textarea', required: false },
			{ name: 'ajType', label: 'Type', type: 'text', required: false },
			{ name: 'atb01', label: 'Attr 1', type: 'text', required: false },
			{ name: 'atb02', label: 'Attr 2', type: 'text', required: false },
			{ name: 'atb03', label: 'Attr 3', type: 'text', required: false },
			{ name: 'atb04', label: 'Attr 4', type: 'text', required: false },
			{ name: 'atb05', label: 'Attr 5', type: 'text', required: false },
			{ name: 'status', label: 'Status', type: 'text', required: false }
			// Add more columns as needed
		];


		this.apiUrl = '/restCommand'; // Replace with your API endpoint
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
		const idFilter = document.getElementById('id').value.trim();
		const commandFilter = document.getElementById('command').value.trim();

		const url = `${this.apiUrl}?id=${idFilter}&command=${commandFilter}`;

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


				if (column.type == 'textarea' && item[column.name] != null) {

					cell.textContent = item[column.name].substring(0, 20) + '...';

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
			id: document.getElementById('id' + itemId).value,
			cmdGroup: document.getElementById('cmdGroup' + itemId).value,
			cmdOrder: document.getElementById('cmdOrder' + itemId).value,
			dsc: document.getElementById('dsc' + itemId).value,
			command: document.getElementById('command' + itemId).value,
			ajType: document.getElementById('ajType' + itemId).value,
			atb01: document.getElementById('atb01' + itemId).value,
			atb02: document.getElementById('atb02' + itemId).value,
			atb03: document.getElementById('atb03' + itemId).value,
			atb04: document.getElementById('atb04' + itemId).value,
			atb05: document.getElementById('atb05' + itemId).value,
			status: document.getElementById('status' + itemId).value
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

			let type = '';
			if (column.type == 'textarea') {
				type = 'textarea';
			} else {
				type = 'input';
			}

			const input = document.createElement(type);
			
			if (column.type != 'textarea') {
				input.type = 'text';
			} else {
				input.setAttribute('rows','15');
			}

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
