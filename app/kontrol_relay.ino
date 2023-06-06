#include <ESP8266WiFi.h>
#include <FirebaseArduino.h>

#define FIREBASE_HOST "kontrolrelay-d4445-default-rtdb.firebaseio.com"
#define FIREBASE_AUTH "E4xNNBVwNrLU4rN0zoDQ5PkI6tzCYMQLEU0GvrwX"
#define WIFI_SSID "CAH UTY"
#define WIFI_PASSWORD "UTY12345"
int relay = 5;//D1
int relay2 = 4;//D2
int relay3 = 0;//D3
   
void setup() {
  Serial.begin(9600);

  // Menyambungkan ke wifi
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Menghubungkan...");
  while (WiFi.status()!=WL_CONNECTED){
    Serial.print(".");
    delay(500);
  }
  Serial.println();
  Serial.print("Tersambung ke:");
  Serial.print(WiFi.localIP());

 pinMode(relay, OUTPUT);
 pinMode(relay2, OUTPUT);
 pinMode(relay3, OUTPUT);

  //Ke Firebase
  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
  Firebase.set("DIANMO1",0);
  Firebase.set("DIANMO2",0);
  Firebase.set("DIANMO3",0);
}
int n = 0;
int a = 0;
int c = 0;

void loop() {
  n = Firebase.getInt("DINAMO1");
  a = Firebase.getInt("DINAMO2");
  c = Firebase.getInt("DINAMO3");

  //Kondisi
  if(n==1) {
    Serial.print("Dinamo1 Menyala");
    digitalWrite(relay, HIGH);
    return;
    delay(1000);
  }
  else{
    Serial.print("\n Dinamo1 Padam");
    digitalWrite(relay, LOW);
  }
  if(a==1) {
    Serial.print("Dinamo2 Menyala");
    digitalWrite(relay, HIGH);
    return;
    delay(2000);
  }
  else{
    Serial.print("\n Dinamo2 Padam");
    digitalWrite(relay, LOW);
  }
  if(c==1) {
    Serial.print("Dinamo3 Menyala");
    digitalWrite(relay, HIGH);
    return;
    delay(3000);
  }
  else{
    Serial.print("\n Dinamo3 Padam");
    digitalWrite(relay, LOW);
  }  

}
