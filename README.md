# LearnSpringSecurity
                                                     Key Filter 
                                                     
SecurityContextPersistenceFilter
-> Manages the SecurityContext for reach request
-> class: org.springframework.security.web.context.SecurityContextPersistenceFilter

WebAsyncManagerIntegrationFilter
-> Integrates the SecurityContext with Spring's WebAsyncManager for asynchronous web request.
-> class : org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter

HeaderWriterFilter
-> Adds security-releated HTTP headers to the response, such as X-Content-Type-Option, X- Frame-Option, and X-XSS-Protection.
-> class: org.springframework.security.web.header.HeaderWriterFilter

CorsFilter
-> Handle Cross-Origin Resource Sharing (CORS) by allowing or denying requests from different origin based on configured policies.
-> class: org.springframework.web.filter.CorsFilter

CsrfFilter
-> Enforces Cross-Site Request Forgery (CSRF) protection by generating and validating CSRF tokens for reach request.
-> class : org.springframework.security.web.csrf.CsrfFilter

LogoutFilter
-> Manages the logout process by invalidating the session, clearing cookies, and redirecting the user to configured success URL.
-> class : org.springframework.security.web.authetication.logout.LogoutFilter

UsernamePasswordAutheticationFilter
-> Process authetication requests for username and password redentials. It handles the form-based login process.
-> class : org.springframework.security.web.authetication.UsernamePasswordAutheticationFilter

DefaultLoginPageGeneratingFilter
-> Genrates a default login page if no custom login page is provided.
-> class : org.springframework.security.web.authetication.ui.DefaultLoginPageGeneratingFilter

DefaultLogoutPageGeneratingFilter
-> Genrates a default logout page if no custom login page is provided.
-> class : org.springframework.security.web.authetication.ui.DefaultLogoutPageGeneratingFilter

BasicAuthenticationFilter
-> Handles HTTP Basic authetication by extracting credentilas from the Authorization header and passing them to the authentication manager.
-> class : org.springframework.security.web.authetication.www.BasicAuthenticationFilter

RequestCacheAwareFilter
-> Ensure that the original requested URL is cached during authentication, so that the user can be redirected to it after successful authentication.
-> class : org.springframework.security.web.savedrequest.RequestCacheAwareFilter

SecurityContextHolderAwareRequestFilter
-> Wraps the request to provide security-releated method (e.g., isUserInRole and getRemoteUser) that interact with SecurityContext
-> class : org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter

AnonymousAuthenticationFilter
-> Provide anonymous authentication for users who are not authenticated. This is useful to apply security constraints even to unauthenticated users.
-> class : org.springframework.security.web.authetication.AnonymousAuthenticationFilter

ExceptionTranslationFilter
-> Translate authentication and access-related exceptions into appropriate HTTP responses, such as redirecting to the login page or sending a 403 Forbidden status.
-> class : org.springframework.security.web.access.ExceptionTranslationFilter

FilterSecurityInterceptor
-> Enforces security policies (authorization checks) on secured HTTP requests. It make final access control decisions based on configured security metadata and the current Authentication.
-> class : org.springframework.security.web.access.intercept.FilterSecurityInterceptor
































