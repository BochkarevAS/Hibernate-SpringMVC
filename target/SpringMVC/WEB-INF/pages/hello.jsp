<html ng-app="personApp">

<head>
	<script src="/resources/js/angular.js"></script>
	<script src="/resources/js/main.js"></script>
</head>

<body>

	<div ng-controller="personController">

		<div id="idx"></div>

		<div id="update" ng-hide="toggle">
			<table>
				<tr>
					<td>Person Name:</td>
					<td><input type="text" ng-model="personName" /></td>
				</tr>
				<tr>
					<td>Person Status:</td>
					<td>
						<select ng-model="personStatus" ng-options="status for status in ['married', 'single', 'in search']">
							<option value="">-- Select --</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Person Sex:</td>
					<td>
						<select ng-model="personSex" ng-options="sex for sex in ['men', 'women']">
							<option value="">-- Select --</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><br/><button ng-click="updatePerson()">Update Person</button></td>
				</tr>
			</table>
		</div>

		<div ng-show="toggle">
			<div class="person" ng-repeat="person in persons">
				<span>{{person.name}}</span>
				<span>{{person.sex}}</span>
				<span>{{person.status}}</span>
				<button ng-click="deletePerson(person.id)">Delete Person</button>
				<button ng-click="toggle(!toggle, person.id)">Show Person Info</button>
			</div>

			<table>
				<tr>
					<td>Person Name:</td>
					<td><input type="text" ng-model="personName" /></td>
				</tr>
				<tr>
					<td>Person Status:</td>
					<td>
						<select ng-model="personStatus" ng-options="status for status in ['married', 'single', 'in search']">
							<option value="">-- Select --</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Person Sex:</td>
					<td>
						<select ng-model="personSex" ng-options="sex for sex in ['men', 'women']">
							<option value="">-- Select --</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><br/><button ng-click="addPerson()">Add New Person</button></td>
				</tr>
			</table>

			<div>
				Search by ID:
				<input type="text" ng-model="id" />
				<button ng-click="searchById()">Search Person</button>
			</div>

		</div>
	</div>


</body>
</html>