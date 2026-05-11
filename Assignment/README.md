# TMF 2954 Java Programming - Group Assignment
**Semester 2, 2025/2026**

## Project Overview
[cite_start]This project is a Java-based application designed to generate an encoded version of user-provided strings through a simple graphical window interface[cite: 5]. [cite_start]The encoding process utilizes a unique, hidden group-specific shift key embedded within the source code to ensure that the output is distinct and traceable[cite: 6, 7].

## Technical Requirements
[cite_start]The application is built using **Java Swing** and follows a specific Object-Oriented design[cite: 49].

### Core Class: `Encoded`
[cite_start]The project implements an `Encoded` class with the following specifications[cite: 9, 12]:
* **Attributes**: `inputText`, `charCount`, `resultText`, and a hidden `groupID`.
* **Methods**:
    * [cite_start]`countCharacters()`: Counts non-space characters in the input[cite: 26].
    * [cite_start]`checkStringValidity()`: Validates that input contains only lowercase alphanumeric characters and spaces[cite: 17, 23].
    * [cite_start]`generateshift()`: Derives a `groupShift` value (between 1 and 10) using `hashCode()` from the hardcoded `groupID`[cite: 27, 28].
    * [cite_start]`applyCipher()`: Applies the encoding logic using a calculated `finalshift`[cite: 12].

### Encoding Logic
[cite_start]The `finalshift` is determined by adding the `groupShift` to the number of non-space characters[cite: 29, 30].
* [cite_start]**Lowercase (a-z)**: Shifted cyclically within the alphabet[cite: 31, 32].
* [cite_start]**Digits (0-9)**: Shifted cyclically within the numbers[cite: 33, 34].
* [cite_start]**Spaces**: Remain unchanged in the output[cite: 37].

## How to Run in VS Code
1.  **Clone the Repository**:
    ```bash
    git clone [Your-GitHub-Repo-URL]
    ```
2.  **Open in VS Code**: Open the folder containing the `.java` files.
3.  **Compile and Run**:
    * Ensure the **Extension Pack for Java** is installed.
    * Open `Assignment.java` (the main execution class).
    * Press `F5` or click the **Run** button above the `main` method.

## GUI Interaction
* [cite_start]**Input**: Enter your lowercase alphanumeric string into the text box[cite: 16].
* [cite_start]**Action**: Click the **Encode** button[cite: 51].
* [cite_start]**Output**: The display area will show the character count, the final shift, and the encoded result[cite: 52].
* [cite_start]*Note: The secret Group ID and groupShift are never displayed at runtime[cite: 53].*

## Collaboration & Attribution
This is a team effort. Contributions are tracked via:
* [cite_start]**Inline Comments**: Specific code blocks are tagged with `// Contributed by [Member Name]`[cite: 59].
* [cite_start]**Code Documentation**: Every method includes a description of its logic and rationale[cite: 55, 56].

### Project Team
| Member Name | Responsibility |
| :--- | :--- |
| **Member 1** | [e.g., UI Design / Swing Implementation] |
| **Member 2** | [e.g., Encoding Logic / Hashing Mechanism] |
| **Member 3** | [e.g., Input Validation / Error Handling] |
| **Member 4** | [e.g., Documentation / Testing] |
| **Member 5** | [e.g., Repository Management / Code Integration] |

## Submission Deadline
[cite_start]**24th May 2026, 11:59 PM** [cite: 3]