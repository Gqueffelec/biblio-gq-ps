<%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<link rel="stylesheet" href="css/style.css">

	<script src="https://use.fontawesome.com/releases/v5.15.2/js/all.js" data-auto-replace-svg="nest"></script>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Bibliothèque</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
			aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navBarDropdownLivre"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gestion
						des Livres </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<button class="btn btn-outline-success ml-5 my-2 my-sm-0" type="submit">Ajouter un
							livre</button>
						<button class="btn btn-outline-success ml-5 my-2 my-sm-0" type="submit">Modifier un
							livre</button>
						<button class="btn btn-outline-success ml-5 my-2 my-sm-0" type="submit">Supprimer un
							livre</button>
					</div>
				</li>
				<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navBarDropdownCategorie"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gestion des
						Catégories </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<button class="btn btn-outline-success ml-5 my-2 my-sm-0" type="button" data-toggle="modal"
							data-target="#newCategorie" id="newCategorieButton">Ajouter une
							catégorie</button>
						<button class="btn btn-outline-success ml-5 my-2 my-sm-0" type="button" data-toggle="modal"
							data-target="#updateCategorie" id="updateCategorieButton">Modifier un catégorie</button>
						<button class="btn btn-outline-success ml-5 my-2 my-sm-0" type="button" data-toggle="modal"
							data-target="#removeCategorie" id="removeCategorieButton">Supprimer un catégorie</button>
					</div>
				</li>
			</ul>
		</div>
	</nav>
	<div class="modal fade" id="newCategorie" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Nouvelle Catégorie</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div id="createCategorieData">
						<label for="nom">Nom</label>
						<input type="text" name="nom" class="nom"></br>
						<label for="label">Label</label>
						<input type="text" name="label" class="label"></br>
						<label for="info">Information Technique</label>
						<input type="text" name="info" class="info"></br>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer </button>
					<button type="button" class="btn btn-primary" id="createCategorie">Ajouter</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="updateCategorie" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modifier une Catégorie</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div id="updateSelectId">
						<label for="id">Name</label>
						<select class="categorieId"></select>
						<button type="button" class="btn btn-primary" id="selectIdUpdate">Select</button>
					</div>
					<div class="categorieData" id="updateCategorieData">
						<label for="nom">Nom</label>
						<input type="text" name="nom" class="nom"></br>
						<label for="label">Label</label>
						<input type="text" name="label" class="label"></br>
						<label for="info">Information Technique</label>
						<input type="text" name="info" class="info"></br>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
					<button type="button" class="btn btn-primary" id="MAJCategorie" disabled>Mettre à jour</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="removeCategorie" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Supprimer une Catégorie</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div>
						<label for="id">Name</label>
						<select class="categorieId"></select>
					</div>
					<div class="categorieData" id="removeCategorieData">
						<label for="nom">Nom</label>
						<input type="text" name="nom" class="nom"></br>
						<label for="label">Label</label>
						<input type="text" name="label" class="label"></br>
						<label for="info">Information Technique</label>
						<input type="text" name="info" class="info"></br>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
					<button type="button" class="btn btn-primary" id="deleteCategorie">Supprimer</button>
				</div>
			</div>
		</div>
	</div>