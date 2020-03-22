# OOP-Calculator

Kalkulator ini ditujukan sebagai pemenuhan tugas besar 1, kelas Pemrograman Berorientasi Objek.<br />
Pemenuhan tugas ini menggunakan bahasa Java.<br /><br />

## Cara Build (Ubuntu)
Dalam proses build tugas ini, kami menggunakan IDE Intellij dengan versi Community.<br />
Library Java yang dibutuhkan adalah `JavaFx`, `Junit 4.12`, dan `Hamcrest 13`<br /><br />

Untuk membuka project, download repository, lalu buka directory.<br />
Project langsung siap untuk di-build, jika sudah mempunyai dependency yang tepat.<br /><br />

### JavaFx
Untuk meng-include `JavaFx`, pertama download filenya, lalu simpan pada suatu folder.<br />
Setelah itu, klik file -> project structure -> global libraries, lalu tambah javafx.<br />
Selain itu, klik tab run -> edit configurations -> tambahkan line ini pada VM Options :<br />
`--module-path "{{path to your javafx folder}}/javafx-sdk-14/lib" --add-modules javafx.controls,javafx.fxml`<br />
Dengan mengganti isi dari {{ }} dengan path ke javafx folder pada komputer anda

### Junit 4 dan Hamcrest
Junit 4 dan Hamcrest sudah sepaket dengan intellij. Untuk meng-include-kan pada project,<br />
Klik file -> project structure -> libraries -> klik tombol +, lalu tambahkan library java.<br />
Setelah itu, include file dari : <br />
`{{path to your intellij install directory}}/intellij/lib/junit 4 dan hamcrest`<br />



