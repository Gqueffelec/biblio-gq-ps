<br>
<br>
<br>

<div class="container">
	<table class="table table-bordered" id="dataTable">
		<thead>
			<tr>
				<th>Catégorie</th>
				<th>Label</th>
				<th>Titre</th>
				<th>Stock</th>
				<th>Prix unitaire</th>
			</tr>
		</thead>
		<tbody>


			<c:forEach items="${livreList }" var="livreList" varStatus="vs">

				<tr class="centrer" id="${livreList.date_edition }">
					<td>${livreList.categorie.nom }</td>
					<td>${livreList.label }</td>
					<td>${livreList.titre }</td>
					<td>${livreList.stock }</td>
					<td>${livreList.prix }</td>
				</tr>

			</c:forEach>


		</tbody>
	</table>
</div>