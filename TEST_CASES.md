# Traat — Sample Data and Test Cases

## 1. Purpose

This document describes sample digital fraud scenarios and functional test cases for the Traat Android prototype.

Test results must be recorded only after the corresponding test has actually been performed.

## 2. Sample Data

All examples below are fictional and intended for testing and awareness.

### Sample 1: Suspicious OTP Request

**Message:**

"Your account will be blocked today. Share your OTP immediately to prevent suspension."

**Warning signs to look for:**
- Urgent or threatening language.
- Request for an OTP.
- Pressure to act without verification.

**Recommended safe action:** Do not share the OTP. Verify the claim through the organisation's official website or app.

### Sample 2: Suspicious Payment Request

**Message:**

"Your refund is pending. Enter your banking PIN to receive the money."

**Warning signs to look for:**
- Request for a confidential banking PIN.
- Unexpected refund claim.
- Pressure to provide sensitive information.

**Recommended safe action:** Do not disclose the PIN. Check the refund through the official payment provider.

### Sample 3: Impersonation Attempt

**Message:**

"I am from customer support. Send your password so I can fix your account."

**Warning signs to look for:**
- Request for a password.
- Unverified identity.
- Attempt to obtain confidential information.

**Recommended safe action:** Do not share the password. Contact the organisation through an independently verified channel.

## 3. Functional Test Cases

| Test ID | Test Scenario | Expected Result |

| TC-01 | Launch the application | Home screen opens without crashing |
| TC-02 | Check the app logo | Logo displays correctly |
| TC-03 | Tap Message Safety | Intended screen opens |
| TC-04 | Enter a sample suspicious message | Input is accepted as supported by the implementation |
| TC-05 | Test a blank message | App handles empty input appropriately |
| TC-06 | Tap Call Safety | Intended screen or demonstration opens |
| TC-07 | Tap Payment Safety | Intended screen or demonstration opens |
| TC-08 | Tap Safety Assistant | Intended screen or demonstration opens |
| TC-09 | Test on the target Android device | Text and controls remain usable |
| TC-10 | Navigate between available screens | No unexpected crash occurs |

## 4. Test Results

Record actual outcomes after running each test.

| Test ID | Actual Result | Status |

| TC-01 | To be recorded | Pending verification |
| TC-02 | To be recorded | Pending verification |
| TC-03 | To be recorded | Pending verification |
| TC-04 | To be recorded | Pending verification |
| TC-05 | To be recorded | Pending verification |
| TC-06 | To be recorded | Pending verification |
| TC-07 | To be recorded | Pending verification |
| TC-08 | To be recorded | Pending verification |
| TC-09 | To be recorded | Pending verification |
| TC-10 | To be recorded | Pending verification |

## 5. Testing Notes

- Use fictional sample messages only.
- Do not enter real passwords, OTPs, banking PINs or confidential personal information.
- Expected results describe intended behaviour; they are not proof that a feature has passed testing.
- Automated fraud-detection accuracy has not been established by these functional tests.

## 6. Conclusion

These scenarios provide a starting point for testing Traat's interface, navigation and digital safety awareness goals. Test statuses should be updated based on actual observed behaviour before final submission.
