L'erreur que vous rencontrez indique que le jeton d'enregistrement que vous utilisez pour envoyer des notifications via Firebase Cloud Messaging (FCM) n'est pas valide. Voici quelques étapes à suivre pour résoudre ce problème :

Assurez-vous que le jeton d'enregistrement est correctement généré et qu'il est toujours valide. Les jetons d'enregistrement peuvent devenir invalides si l'application est désinstallée ou si l'utilisateur efface les données de l'application.
Vérifiez que le jeton d'enregistrement que vous utilisez dans votre requête POST à https://fcm.googleapis.com/v1/projects/stockage-photo-b8c98/messages:send est bien le même que celui qui a été généré par l'appareil client.
Si vous avez mis à jour votre application, assurez-vous que le jeton d'enregistrement est également mis à jour.
Voici un exemple de code pour obtenir un nouveau jeton d'enregistrement dans une application Android :

FirebaseInstanceId.getInstance().getInstanceId()
        .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                if (!task.isSuccessful()) {
                    Log.w(TAG, "getInstanceId failed", task.getException());
                    return;
                }

                // Get new Instance ID token
                String token = task.getResult().getToken();

                // Log and toast
                String msg = getString(R.string.msg_token_fmt, token);
                Log.d(TAG, msg);
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
Dans cet exemple, FirebaseInstanceId.getInstance().getInstanceId() est utilisé pour obtenir le jeton d'enregistrement actuel. Ce jeton doit ensuite être utilisé dans la requête POST à l'API FCM.

Le jeton d'enregistrement doit être celui de l'appareil sur lequel vous voulez envoyer une notification. Lorsque vous envoyez une notification via FCM, vous devez spécifier le jeton d'enregistrement de l'appareil destinataire dans la requête POST à l'API FCM. Le jeton d'enregistrement est généré par l'application installée sur l'appareil du destinataire lorsqu'elle se connecte au service FCM pour la première fois 123.

Si vous ne disposez pas du bon jeton d'enregistrement, vous pouvez le valider en utilisant une requête CURL comme indiqué dans la source 0. Cette requête permet de vérifier si un jeton d'enregistrement est valide sans envoyer réellement un message. Si le jeton n'est pas valide, la réponse contiendra une erreur "InvalidRegistration".

Voici un exemple de requête CURL pour valider un jeton d'enregistrement :

curl -H "Content-Type: application/json" -H "Authorization: key=$FCM_API_KEY" https://fcm.googleapis.com/fcm/send -d '{"registration_ids":["$FCMTOKEN"], "dry_run": true}'
Remplacez $FCM_API_KEY par votre clé API FCM et $FCMTOKEN par le jeton que vous souhaitez valider 1.

Pour obtenir le jeton FCM (Firebase Cloud Messaging) d'un utilisateur lorsque vous n'avez que son ID, vous devez implémenter une logique dans votre application cliente pour enregistrer le jeton FCM sur votre serveur lorsque l'application est installée ou mise à jour.

Voici comment vous pouvez le faire dans une application Android :

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        // Send the token to your server
        sendRegistrationToServer(token);
    }
}
Dans ce code, onNewToken est appelé chaque fois que le jeton FCM est généré ou rafraîchi. Vous devez remplacer sendRegistrationToServer(token) par votre propre logique pour envoyer le jeton à votre serveur 3.

Notez que cette méthode nécessite que l'utilisateur ait installé l'application sur son appareil et qu'il se soit connecté à votre application. Si l'utilisateur n'a pas installé l'application ou s'il n'est pas connecté, vous ne pourrez pas obtenir son jeton FCM.

De plus, le jeton FCM peut changer si l'application est désinstallée et réinstallée, ou si l'utilisateur efface les données de l'application. Par conséquent, vous devez gérer ces cas dans votre application et mettre à jour le jeton FCM sur votre serveur en conséquence 3.


https://www.it-connect.fr/chapitres/recuperer-des-informations-sur-les-utilisateurs-avec-powershell/
https://stackoverflow.com/questions/68812443/how-to-specify-sender-id-in-fcm
https://stackovercoder.fr/programming/37787373/firebase-fcm-how-to-get-token
https://learn.microsoft.com/fr-fr/entra/identity/saas-apps/fcm-hub-tutorial
https://prograide.com/pregunta/70904/quest-ce-que-le-jeton-fcm-dans-firebase