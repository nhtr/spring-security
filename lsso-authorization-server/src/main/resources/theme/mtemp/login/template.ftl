<#macro registrationLayout bodyClass="" displayInfo=false displayMessage=true displayWide=false>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <title>${msg("loginTitle",(realm.displayName!''))}</title>
    <link rel="shortcut icon" href="${url.resourcesPath}/img/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${url.resourcesPath}/css/layout-teal-yellow.css">
    <link rel="stylesheet" type="text/css" href="${url.resourcesPath}/css/theme-teal-yellow.css">
    <link rel="stylesheet" type="text/css" href="${url.resourcesPath}/css/primeng.min.css">
</head>

<body class="login-body">
        <#nested "header">
        <#if displayMessage && message?has_content>
	        <div class="alert alert-${message.type}">
	             <#if message.type = 'success'><span class="${properties.kcFeedbackSuccessIcon!}"></span></#if>
	             <#if message.type = 'warning'><span class="${properties.kcFeedbackWarningIcon!}"></span></#if>
	             <#if message.type = 'error'><span class="${properties.kcFeedbackErrorIcon!}"></span></#if>
	             <#if message.type = 'info'><span class="${properties.kcFeedbackInfoIcon!}"></span></#if>
	             <span class="message-text">${message.summary?no_esc}</span>
	        </div>
        </#if>
        <#nested "form">
	</body>
</html>
</#macro>
