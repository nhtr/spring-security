<#import "template.ftl" as layout>
<@layout.registrationLayout displayInfo=social.displayInfo; section>
<#if section="header">
	<div class="ui-g">
		<div class="ui-g-12" style="text-align: center">
			<img src="${url.resourcesPath}/img/logo-manhattan.png" class="logo" />
		</div>
	</div>
<#elseif section="form">
	<div class="login-panel ui-fluid">
		<div class="ui-g">
			<div class="ui-g-6 left-side">
				<img src="${url.resourcesPath}/img/login-photo.png" class="login-image" />
			</div>
			<div class="ui-g-6 ui-sm-12 right-side">
				<div class="ui-g-12 container">
					<h3>Welcome guest!</h3>
					<h2>Sign in to Manhattan Network</h2>
				</div>
				<div class="ui-g-12">
					<label for="username" value="Username"></label>
					<div class="input-wrapper">
						<input type="text" autocomplete="off" placeholder="Username"
							class="ui-inputtext ui-widget"> <i class="fa fa-user"></i>
					</div>
				</div>
				<div class="ui-g-12">
					<label for="password" value="Password"></label>
					<div class="input-wrapper">
						<input type="password" autocomplete="off" placeholder="Username"
							class="ui-inputtext ui-widget"> <i class="fa fa-lock"></i>
					</div>
				</div>
				<div class="ui-g-12 button-container">
					<button type="button"
						class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only blue-btn raised-btn">
						<span class="ui-button-text ui-c">Sign In</span>
					</button>
				</div>
			</div>
		</div>
	</div>
</#if>
</@layout.registrationLayout>