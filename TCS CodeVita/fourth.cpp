#include <iostream>
#include <sstream>
#include <set>
#include <vector>
#include <string>
using namespace std;

// Helper function to parse an equation and extract coefficients and the limit
vector<int> parseEquation(const string& eq) {
    vector<int> coefficients(4);  // For x, y, z, w coefficients
    int N;

    // Split the equation at "<="
    size_t pos = eq.find("<=");
    string leftSide = eq.substr(0, pos);
    N = stoi(eq.substr(pos + 2));  // Extract N from the right side of "<="

    // Extract coefficients for x, y, z, w from the left side of the equation
    stringstream ss(leftSide);
    string term;

    while (getline(ss, term, '+')) {
        if (term.find('x') != string::npos) {
            coefficients[0] = stoi(term.substr(0, term.find('x')));
        } else if (term.find('y') != string::npos) {
            coefficients[1] = stoi(term.substr(0, term.find('y')));
        } else if (term.find('z') != string::npos) {
            coefficients[2] = stoi(term.substr(0, term.find('z')));
        } else if (term.find('w') != string::npos) {
            coefficients[3] = stoi(term.substr(0, term.find('w')));
        }
    }

    coefficients.push_back(N);  // Append the limit N
    return coefficients;
}

int solveEquation(const string& eq1, const string& eq2, int R) {
    vector<int> eq1Coeffs = parseEquation(eq1);
    vector<int> eq2Coeffs = parseEquation(eq2);

    int N1 = eq1Coeffs[4];
    int N2 = eq2Coeffs[4];

    // If N1 != N2, there can't be any valid solutions
    if (N1 != N2) {
        return 0;
    }

    set<int> results;

    // Brute-force all possible combinations of x, y, z, w such that x + y + z + w <= R
    for (int x = 0; x <= R; ++x) {
        for (int y = 0; y <= R - x; ++y) {
            for (int z = 0; z <= R - x - y; ++z) {
                for (int w = 0; w <= R - x - y - z; ++w) {
                    int result1 = eq1Coeffs[0] * x + eq1Coeffs[1] * y + eq1Coeffs[2] * z + eq1Coeffs[3] * w;
                    int result2 = eq2Coeffs[0] * x + eq2Coeffs[1] * y + eq2Coeffs[2] * z + eq2Coeffs[3] * w;

                    // Debugging: Print the intermediate results
                    cout << "x: " << x << " y: " << y << " z: " << z << " w: " << w
                         << " eq1: " << result1 << " eq2: " << result2 << endl;

                    // Add to results if both results are equal and within bounds
                    if (result1 == result2 && result1 <= N1) {
                        results.insert(result1);
                    }
                }
            }
        }
    }

    cout << "Number of valid results: " << results.size() << endl;
    return results.size();  // Return the number of distinct results
}

int main() {
    string eq1, eq2;
    int R;

    // Input
    getline(cin, eq1);  // Get the first equation
    getline(cin, eq2);  // Get the second equation
    cin >> R;           // Get the sum constraint R

    // Solve and output the result
    cout << solveEquation(eq1, eq2, R) << endl;

    return 0;
}
