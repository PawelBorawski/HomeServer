<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Log into Home Server</title>
    </head>
    <body>
        <form role="form" action="/login" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div>
                <label for="email">Email address</label>
                <input type="email" name="email" id="email"/>
            </div>
            <div>
                <label for="password">Password</label>
                <input type="password" name="password" id="password"/>
            </div>
            <button type="submit">Sign in</button>
        </form>
    </body>
</html>