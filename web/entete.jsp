<!-- Entête du site -->
<header>
    <nav class="blue" role="navigation">
        <div class="nav-wrapper container">
            <a href="index.jsp" class="brand-logo" style="font-size: 30px;"><i class="material-icons left deep-orange-text hide-on-med-and-down">favorite</i>Fr&eacute;quence Cardiaque</a>
            <ul id="" class="right hide-on-med-and-down">

                <c:choose>
                    <c:when test="${sessionScope.nom != null}">
                        <li>
                            <a class="dropdown-button" data-activates="options" data-beloworigin="true">
                                <div class="chip">

                                    <img src="img/8biticon.jpg" alt="${sessionScope.nom}">
                                        ${sessionScope.nom} 
                                </div>
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="connexion.jsp"><i class="material-icons left">perm_identity</i>Connexion</a></li>
                    </c:otherwise>

                </c:choose>
                <!-- Dropdown Structure -->
                <ul id="options" class="dropdown-content">
                  <li><a href="graphique.jsp">Mon Activit&eacute;</a></li>
                  <li><a href="dossier.jsp">Mon Dossier</a></li>
                  <li><a href="compte.jsp">Mon Compte</a></li>
                  <li class="divider"></li>
                  <li><a href="Deconnexion">D&eacute;connexion</a></li>
                </ul>

            </ul>
            <!-- Vue Mobile -->
            <ul id="nav-mobile" class="side-nav">
                <li><a>${sessionScope.nom}</a></li>
            </ul>
            <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
        </div>
    </nav>
</header>