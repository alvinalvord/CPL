#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <iostream>
#include <sstream>
#include <chrono>

typedef char String[101];

typedef struct {
	String s;
	char skip[100];
} Data;

int len;

bool
match (Data a, Data b)
{
	for (int i = 0; i < len; ) {
		if (a.s[i] == '-') {
			i += a.skip[i];
		} else if (b.s[i] == '-') {
			i += b.skip[i];
		} else {
			if (a.s[i] == b.s[i]) {
				i += std::min (a.skip[i], b.skip[i]);
			} else return false;
		}
	}
	return true;
}

int
main (int argc, char *argv[])
{
    std::chrono::system_clock::time_point t1 = std::chrono::system_clock::now ();
	
	int n;
	Data *data;
	
	data = (Data *) malloc (sizeof (Data) * 20000);
	
	scanf ("%d", &n);
	for (int i = 0; i < n; i++) scanf ("%s", data[i].s);
	len = strlen (data[0].s);
	
	for (int i = n - 1; i >= 0; i--) {
		data[i].skip[len - 1] = 1;
		for (int j = len - 2; j >= 0; j--) {
			if (data[i].s[j] == data[i].s[j + 1])
				data[i].skip[j] = data[i].skip[j + 1] + 1;
			else data[i].skip[j] = 1;
		}
	}
	
	bool flag;
	std::ostringstream sb;
	for (int i = 1; i < n; i++) {
		flag = false;
		for (int j = 0; j < i; j++) {
			if (match (data[i], data[j])) {
				if (!flag) sb << i + 1 << ":";
				flag = true;
				sb << " " << j + 1;
			}
		}
		if (flag) sb << "\n";
	}
	
	std::cout << sb.str ();
	free (data);
	
    std::chrono::system_clock::time_point t2 = std::chrono::system_clock::now ();

    std::chrono::duration<double> duration = t2 - t1;

    std::cout << duration.count ();
	return 0;
}