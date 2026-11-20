<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Banque d'images - Erreur</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
<header>
    <h1>Banque d'images</h1>
    <nav>
        <a class="button" href="${pageContext.request.contextPath}/">Aléatoire</a>
        <a class="button" href="${pageContext.request.contextPath}/?page=select">Personnalisé</a>
    </nav>
</header>
<main>
    <div class="card error">
        <h2>Erreur</h2>
        <p>${errorMessage}</p>
        <a class="button" href="${pageContext.request.contextPath}/?page=select">Retour au formulaire</a>
    </div>
</main>
</body>
</html>