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


}
