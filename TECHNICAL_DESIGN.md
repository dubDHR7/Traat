# Traat — Technical Design Document

## 1. Overview

Traat is an Android application prototype designed to promote digital fraud awareness and safer online behaviour. It uses Java for application logic and XML for user interface layouts.

The application follows a modular screen-based design, with a home screen providing access to different digital safety features.

## 2. Technology Stack

- **Platform:** Android
- **Programming language:** Java
- **User interface:** XML layouts
- **IDE:** Android Studio
- **Application package:** `com.karamparampara.traat`

## 3. Architecture

The prototype uses a simple Android application architecture.

```text
+-----------------------------+
|         User                |
+--------------+--------------+
               |
               v
+-----------------------------+
|      MainActivity           |
|   Home Screen / Navigation  |
+--------------+--------------+
               |
       +-------+-------+-------+-------+
       |               |               |
       v               v               v
+-------------+ +-------------+ +-------------+
|   Message   | |    Call     | |   Payment   |
|   Safety    | |   Safety    | |   Safety    |
+-------------+ +-------------+ +-------------+
       |
       v
+-----------------------------+
| User-Provided Message Text   |
| Review / Safety Guidance     |
+-----------------------------+

       +-----------------------------+
       | Safety Assistant Interface  |
       +-----------------------------+
```

The diagram represents the conceptual screen structure. Actual processing and navigation depend on the implemented Java activities and XML layouts.

## 4. Main Components

### Home Screen

The home screen introduces Traat and provides navigation to the available safety sections.

### Message Safety

This section provides an interface for entering or reviewing suspicious message text. Its purpose is to help users consider possible warning signs and safer next steps.

### Call Safety

This section represents the call-safety concept. It does not imply continuous call recording or automatic access to call audio.

### Payment Safety

This section represents payment-related safety awareness and encourages users to verify requests before acting.

### Safety Assistant

This section provides an entry point for the assistant concept. Its capabilities depend on the functionality implemented in the prototype.

## 5. User Flow

1. The user launches Traat.
2. The home screen displays the available safety sections.
3. The user selects a relevant section.
4. The application displays the corresponding interface.
5. The user reviews the available information or enters supported input.
6. The user uses the guidance to make a more informed decision.

## 6. Data and Privacy

The prototype should only access information required for its implemented functions. Any future contact access, message processing, call-related functionality or external service integration must be designed with appropriate permissions, user consent and privacy safeguards.

The current design does not claim access to private WhatsApp conversations, continuous call monitoring or UPI transaction interception.

## 7. Security Considerations

- Request only necessary Android permissions.
- Avoid collecting unnecessary personal information.
- Do not store passwords, OTPs or banking PINs.
- Protect any future API credentials and private configuration.
- Validate user input where applicable.
- Provide clear limitations for any automated risk assessment.

## 8. Limitations

Traat is a prototype. Its interfaces demonstrate a digital safety concept and do not establish the accuracy of automated fraud detection. Advanced detection, integrations and multilingual assistance require further implementation and testing.

## 9. Future Scope

- Improved suspicious-message analysis.
- Regional-language safety guidance.
- Additional educational examples and fraud scenarios.
- Privacy-preserving risk assessment.
- Carefully evaluated integrations with supported Android capabilities.

## 10. Conclusion

Traat explores a mobile-first approach to digital fraud awareness. Its modular Android structure provides a foundation for future development while emphasizing user awareness, privacy and responsible use.
