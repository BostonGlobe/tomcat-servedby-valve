# tomcat-servedby-valve
Adds a "Served-By" header to requests served by Tomcat. Useful for clusters.

## Usage

Add the valve to a host in server.xml:

    <Host name="localhost" appBase="webapps" unpackWARs="true" autoDeploy="false" xmlValidation="false" xmlNamespaceAware="false">
        <Valve className="com.boston.tomcat.valve.ServedByHeaderValve" />
    </Host>
