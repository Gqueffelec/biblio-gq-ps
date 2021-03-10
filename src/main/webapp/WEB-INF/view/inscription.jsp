<div class="container">
	<div class="row">
		<div class="col-md-6">
			<div class="card">
				<form class="box" method="post" action="signIn">
					<h1>Inscription</h1>
					<p class="text-muted">Please enter your login and password!</p>
				<h4 style="color:red"><c:out value="${error }"></c:out></h4>
					<input type="text" name="user" placeholder="Username"> <input
						type="password" name="password" placeholder="Password"> <input
						type="password" name="password2" placeholder="Confirm password"><input
						type="submit" name="login" value="Sign In">
					<div class="col-md-12">
						<!-- <ul class="social-network social-circle">
							<li><a href="#" class="icoFacebook" title="Facebook"><i
									class="fab fa-facebook-f"></i></a></li>
							<li><a href="#" class="icoTwitter" title="Twitter"><i
									class="fab fa-twitter"></i></a></li>
							<li><a href="#" class="icoGoogle" title="Google +"><i
									class="fab fa-google-plus"></i></a></li>
						</ul> -->
						-->
					</div>
				</form>
			</div>
		</div>
	</div>
</div>