# Aim Booster FF

Aplikasi Android Aim Booster untuk game Free Fire dengan tema sci-fi hitam merah.

---

## DAPATKAN APK SIAP PAKAI (Tanpa Compile di PC)

**Cara termudah** – APK akan dibuild otomatis di cloud:

1. **Buat akun GitHub** (gratis) di [github.com](https://github.com)
2. **Unggah project ini ke GitHub:**
   - Klik "New repository"
   - Beri nama (misal: `AimBoosterFF`)
   - Upload semua file project (bisa drag-drop folder)
3. **Tunggu build selesai** – GitHub Actions akan build APK otomatis
4. **Download APK:**
   - Buka repository → tab **Actions**
   - Klik workflow run terbaru (yang hijau)
   - Scroll ke **Artifacts** → klik **AimBoosterFF-APK** untuk download
5. **Instal di HP** – kirim file APK ke HP (WhatsApp/email/Flash drive) lalu install

Tidak perlu Java, Android Studio, atau compile apapun di komputer Anda.

---

## Fitur

- **Enhanced Aim** – Tips meningkatkan akurasi aim, crosshair placement, tracking, dan kontrol recoil
- **Boost Aim** – Rutinitas warm-up dan preset aim yang direkomendasikan
- **Sensitivity Settings** – Pengaturan sensitivity untuk General, Red Dot, 2x, 4x, dan AWM scope dengan slider
- **About This Device** – Informasi device (model, Android version, RAM, storage, dll)

## Tema

- Warna utama: Hitam (#0D0D0D, #1A1A1A)
- Aksen: Merah (#E53935)
- Desain kartu dengan border merah

## Requirements

- Android Studio Hedgehog | 2023.1.1 atau lebih baru
- JDK 17
- Android SDK 34
- Min SDK 24

## Cara Build Manual (jika punya Android Studio)

1. Buka project di Android Studio
2. File → Sync Project with Gradle Files
3. Build → Make Project
4. Jalankan di emulator atau device: Run → Run 'app'

## Menjalankan via Command Line

```bash
# Windows
gradlew.bat assembleDebug

# Linux/Mac
./gradlew assembleDebug
```

APK hasil build: `app/build/outputs/apk/debug/app-debug.apk`

## Struktur Project

```
app/
├── src/main/
│   ├── java/com/aimbooster/ff/
│   │   ├── MainActivity.kt
│   │   └── fragments/
│   │       ├── HomeFragment.kt
│   │       ├── EnhancedAimFragment.kt
│   │       ├── BoostAimFragment.kt
│   │       ├── SensitivityFragment.kt
│   │       └── AboutFragment.kt
│   ├── res/
│   │   ├── layout/
│   │   ├── drawable/
│   │   ├── values/
│   │   └── mipmap-anydpi-v26/
│   └── AndroidManifest.xml
└── build.gradle.kts
```

## Catatan

- Jika launcher icon tidak muncul di device lama (pre-API 26), generate icon via: File → New → Image Asset
- Sensitivity yang diatur di app harus dimasukkan manual ke Free Fire (Settings → Sensitivity)
