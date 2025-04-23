# Mock License Scanner

A simple Kotlin project that scans a text file for known open-source licenses like MIT and Apache 2.0 and displays relevant terms.

## How it works
- Reads a `.txt` file containing mixed contents.
- Searches for known license keywords.
- Outputs results with license name, line number, and summary of terms.

## How to run
1. Clone this repo.
2. Open in intellij IDEA.
3. Run `main.kt`.
4. The program will:
   - Scan the input file for licenses.
   - Write results to `output.txt`.
   - Automatically open `output.txt` in yout system's default text editor (e.g., Notepad on Windows).

## Example Output
Line 1: MIT License found.
Terms: Must include a copy of the MIT License and copyright notice.
Line 7: Apache License 2.0 found.
Terms: redistribution must provide a copy of this license and state modifications.

Summary:
MIT License - 1 match(es)
Apache License 2.0 - 1 match(es)

## Tech used
- Kotlin
- Intellij IDEA
- Git

## License
This project is open source
