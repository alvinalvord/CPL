#include <iostream>
int main () {
	std::ios::sync_with_stdio (false);
	int n, a, b;
	std::cin >> n;
	while (n--) {
		std::cin >> a; std::cin >> b;
		std::cout << a + b << std::endl;
	}
	return 0;
}