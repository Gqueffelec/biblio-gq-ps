<div class="container">
	<div class="row">
		<div class="col-md-6">
			<div class="card">
				<form class="box" method="post" action="login">
					<h1>Login</h1>
					<p class="text-muted">Please enter your login and password!</p>
					<h4 style="color:red"><c:out value="${error }"></c:out></h4>
					<input type="text" name="user" placeholder="Username"> <input
						type="password" name="password" placeholder="Password"> <a
						class="forgot text-muted" href="#">Forgot password?</a> <input
						type="submit" name="login" value="Login">
					<div class="col-md-12">
						<ul class="social-network social-circle">
							<li><a href="#" class="icoFacebook" title="Facebook"><i
									class="fab fa-facebook-f"></i></a></li>
							<li><a href="#" class="icoTwitter" title="Twitter"><i
									class="fab fa-twitter"></i></a></li>
							<li><a href="#" class="icoGoogle" title="Google +"><i
									class="fab fa-google-plus"></i></a></li>
						</ul>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>