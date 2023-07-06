class LogsController {
	
	constructor() {
		this.columns = [
			{ name: 'moment', label: 'Moment', type: 'text', required: false },
			{ name: 'rootPid', label: 'rootPid', type: 'text', required: false },
			{ name: 'pid', label: 'pid', type: 'text', required: false },
			{ name: 'fatherPid', label: 'fatherPid', type: 'text', required: false },
			{ name: 'job', label: 'Job', type: 'text', required: false },
			{ name: 'origin', label: 'Origin', type: 'text', required: false },
			{ name: 'message', label: 'Message', type: 'text', required: false },
			{ name: 'ajTaskGroup', label: 'Task Group', type: 'text', required: false },
			{ name: 'ajConfId', label: 'Conf Id', type: 'text', required: false },
			{ name: 'ajInstance', label: 'Instance', type: 'text', required: false },
			{ name: 'ajEntityName', label: 'Entity Name', type: 'text', required: false }
			// Add more columns as needed
		];

		this.apiUrl = '/restLogs'; // Replace with your API endpoint
		this.grid = document.getElementById('grid');
		this.gridBody = document.getElementById('gridBody');
		this.editForm = document.getElementById('editForm');
		this.itemForm = document.getElementById('itemForm');

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
		const rootPidFilter = document.getElementById('rootPid').value.trim();

		const url = `${this.apiUrl}?rootPid=${rootPidFilter}`;

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


			this.gridBody.appendChild(row);

			counter++;
		}
	}


}
