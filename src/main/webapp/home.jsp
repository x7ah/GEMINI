<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!doctype html>
		<html lang="en">

		<head>
			<title>La liga</title>
			<!-- Required meta tags -->
			<meta charset="utf-8" />
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

			<!-- Bootstrap CSS v5.2.1 -->
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		</head>

		<body>
			<div class="container shadow-lg p-0">
				<header class="bg-primary text-white py-2">
					<div class="row align-items-center">
						<div class="col">
							<img src="img/logoliga.png" alt="" class="img-fluid">
						</div>
						<c:choose>
							<c:when test="${usuario==null}">
								<div class="col">
									<button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#modalLogin">Login</button>
								</div>
							</c:when>
							<c:otherwise>
								<div class="col">
									<div class="row">
										<div class="col text-end">
											<h2>Welcome ${usuario.nombre}</h2>
										</div>
										<div class="col">
											<a class="btn btn-danger" href="Controller?op=logout">Logout</a>
										</div>
									</div>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</header>
				<main>
					<div class="row justify-content-center my-4">
						<div class="col-md-6">
							<form action="Controller?op=vajornada" method="post">
								<div>
									<select class="form-select form-select-lg" name="jornada" id="" onchange="this.form.submit()">
										<option disabled selected>Seleccione jornada</option>
										<c:forEach items="${jornadas}" var="jornada">
											<option value="${jornada.idjornada}">${jornada.nombre} (${jornada.fechainicio} -
												${jornada.fechafin})</option>
										</c:forEach>
									</select>
								</div>
							</form>
						</div>
					</div>
					<c:choose>
						<c:when test="${empty listaPartidos}">
							<section class="px-5 pb-5">
								<img src="img/fotoliga.jpg" alt="" class="img-fluid w-100">
							</section>
						</c:when>
						<c:otherwise>
							<c:forEach items="${listaPartidos}" var="partido">
								<section>
									<div class="row border-secondary border-bottom align-items-center mb-5 mx-5">
										<c:if test="${usuario!=null}">
											<div class="col text-start">
												<button class="btn btn-danger w-100" data-bs-toggle="modal" data-bs-target="#modalResume"><i
														class="fa fa-info-circle" aria-hidden="true"></i></button>
											</div>
										</c:if>
										<div class="col text-end">
											<img src="${partido.equipo1.escudo}" alt="" width="100" class="img-fluid">
										</div>
										<div class="col text-end">
											<h3>${partido.equipo1.nombre}</h3>
										</div>
										<div class="col text-center">
											<h2>${partido.goleslocal} - ${partido.golesvisitante}</h2>
										</div>
										<div class="col text-start">
											<h3>${partido.equipo2.nombre}</h3>
										</div>
										<div class="col">
											<img src="${partido.equipo2.escudo}" alt="" width="100" class="img-fluid">
										</div>
										<c:if test="${usuario!=null}">
											<div class="col text-end">
												<button class="btn btn-danger w-100" data-bs-toggle="modal" data-bs-target="#modalApuesta"
													data-bs-local="${partido.equipo1.nombre}"
													data-bs-visitante="${partido.equipo2.nombre}">Apostar</button>
											</div>
										</c:if>
									</div>
								</section>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</main>
				<footer>
					<!-- place footer here -->
				</footer>


				<!-- Modal Login-->
				<div class="modal fade" id="modalLogin" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Login & Register</h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<form action="Controller?op=login" method="post">

									<div class="mb-3">
										<label for="" class="form-label">DNI</label>
										<input type="text" class="form-control" name="dni" id="" rows="1" required>
									</div>

									<div class="mb-3">
										<label for="" class="form-label">Nombre</label>
										<input type="text" class="form-control" name="nombre" id="" rows="1" required>
									</div>

									<div class="modal-footer">
										<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
										<button type="submit" class="btn btn-primary">Login&Register</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>


				<!-- Modal Resumen-->
				<div class="modal fade" id="modalResume" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Información apuestas actuales</h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								Body
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-danger text-black">Aceptar</button>
							</div>
						</div>
					</div>
				</div>


				<!-- Modal Apostar-->
				<div class="modal fade" id="modalApuesta" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title"></h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<form action="Controller?op=apuesta" method="post">

									<div class="mb-3">
										<label for="" class="form-label">Goles Local</label>
										<input type="text" class="form-control" name="golesLocal" id="" rows="1">
									</div>

									<div class="mb-3">
										<label for="" class="form-label">Goles Visitante</label>
										<input type="text" class="form-control" name="golesVisitante" id="" rows="1">
									</div>

									<div class="modal-footer">
										<button type="button" class="btn btn-light text-black">Apostar</button>
										<button type="button" class="btn btn-light text-black" data-dismiss="modal">Cancel</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Bootstrap JavaScript Libraries -->
			<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
				integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
				crossorigin="anonymous"></script>

			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
				integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
				crossorigin="anonymous"></script>

			<script src="/scripts/js.js" type="text/javascript"></script>
		</body>

		</html>