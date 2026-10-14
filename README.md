# Traat — Digital Safety Assistant

**Tagline:** Pause. Verify. Stay Safe.

Traat is an Android application prototype focused on digital fraud awareness and safer online behaviour. It aims to help users recognize potential warning signs in suspicious messages, calls and payment-related situations, and understand safer actions before sharing sensitive information or making financial decisions.

## Problem Statement

Digital fraud attempts may involve phishing messages, impersonation, fake payment requests, and attempts to obtain OTPs, passwords or banking information. Users may find it difficult to identify warning signs or know what to do when faced with a suspicious request.

Traat explores an accessible, mobile-first approach to digital safety awareness.

## Objectives

- Promote awareness of common digital fraud techniques.
- Encourage users to pause and verify suspicious requests.
- Provide a simple interface for exploring digital safety guidance.
- Build a foundation for future fraud-awareness features.

## Current Prototype

The prototype includes the following sections:

- **Message Safety:** Interface for reviewing suspicious message text and exploring potential warning signs.
- **Call Safety:** Interface demonstrating the call-safety concept.
- **Payment Safety:** Interface demonstrating payment-safety awareness.
- **Safety Assistant:** Entry point for the digital safety assistant concept.

Feature behaviour may vary by screen. The prototype does not claim guaranteed fraud detection, continuous call monitoring, private WhatsApp message access, or interception of UPI transactions.

## Technology Stack

- **Platform:** Android
- **Programming language:** Java
- **UI:** XML layouts
- **Development environment:** Android Studio
- **Application package:** `com.karamparampara.traat`

## Project Structure

The project follows a standard Android application structure.

```text
Traat/
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com/karamparampara/traat/
│           ├── res/
│           │   ├── drawable/
│           │   ├── layout/
│           │   └── values/
│           └── AndroidManifest.xml
├── gradle/
├── build.gradle (or build.gradle.kts)
├── settings.gradle (or settings.gradle.kts)
├── gradlew
├── gradlew.bat
├── README.md
├── TECHNICAL_DESIGN.md
├── TEST_CASES.md
└── LICENSE
```

*Note: The structure above is illustrative. Actual files and directories depend on the current project.*

## Setup Instructions

### Requirements

- Android Studio
- A compatible JDK configured through Android Studio
- Android SDK components required by the project
- An Android phone with USB debugging enabled, or a compatible emulator

### Run Locally

1. Clone or download this repository.
2. Open Android Studio.
3. Select **Open** and choose the downloaded `Traat` project folder.
4. Allow Gradle to sync and download the required dependencies.
5. Connect an Android device with USB debugging enabled, or start an emulator.
6. Select the `app` run configuration.
7. Click **Run** to install and launch the application.

If Gradle sync or the build fails, check the Android Studio Build output and ensure the installed SDK and Gradle configuration are compatible with the project.

## Environment Variables and Configuration

The current prototype does not require any documented external API keys or environment variables to launch, unless additional integrations are introduced in the project.

Do not commit passwords, private keys, signing credentials, or other secrets. Keep machine-specific configuration files such as `local.properties` out of the public repository.

## Testing

The prototype should be tested on a compatible Android device or emulator.

Suggested checks include:

- Application launches successfully.
- Home screen and logo display correctly.
- Navigation buttons open the intended screens.
- Message Safety accepts the intended user input.
- Warnings and guidance display as expected.
- Layouts remain readable on the target screen size.

Detailed test scenarios and their actual results will be documented in `TEST_CASES.md`.

## Limitations and Future Scope

Traat is an early-stage prototype. Automated scam classification, multilingual assistance, advanced caller-risk checks and integrations with external messaging or payment services may require additional implementation, permissions, security review and compatibility testing.

Android restricts access to private communications and call audio. Future features must respect platform policies, user consent, privacy and applicable law.

## Responsible Use

Traat is intended to support digital fraud awareness and informed decision-making. It is not a guarantee that a message, caller or transaction is safe, and it does not replace official reporting channels or professional assistance.

Never share OTPs, passwords, PINs or confidential banking details with unverified people.

## Alignment with the UN Sustainable Development Goals

Traat's digital safety awareness objectives relate to:

- **SDG 16:** Peace, Justice and Strong Institutions — supporting awareness and prevention of fraud.
- **SDG 9:** Industry, Innovation and Infrastructure — exploring accessible digital safety technology.

## Project Documentation

- `TECHNICAL_DESIGN.md` — Application architecture and design.
- `TEST_CASES.md` — Sample scenarios and testing results.
- `LICENSE` — Copyright and permitted use.

## Project Information

- **Project:** Traat
- **Category:** Digital Fraud Awareness and Safety
- **Platform:** Android
- **Status:** Prototype
- **Developer/Project Owner:** [Add your preferred attribution]

---

**Traat — Pause. Verify. Stay Safe.**
