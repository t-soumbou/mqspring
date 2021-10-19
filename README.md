#Lancez un serveur MQ local à l'aide de Docker
docker run ‑‑env LICENSE=accept ‑‑env MQ_QMGR_NAME=QM1
           ‑‑publish 1414:1414
           ‑‑publish 9443:9443
           ‑‑detach
           ibmcom/mq
         
#Vérifiez que le serveur fonctionne en utilisant docker ps:
$ docker ps

#Ajoutez la configuration du serveur MQ dans application.properties:

ibm.mq.queueManager=QM1
ibm.mq.channel=DEV.ADMIN.SVRCONN
ibm.mq.connName=localhost(1414)
ibm.mq.user=admin
ibm.mq.password=passw0rd
