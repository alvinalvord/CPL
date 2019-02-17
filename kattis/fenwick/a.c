#include <stdio.h>

#define lsb(i) ((i) & -(i))

#define size 5000005

typedef long long ll;
ll arr[size];

ll
sum (ll i)
{
	ll sum = arr[0];
	while (i > 0) 
		sum += arr[i], i -= lsb(i);
	return sum;
}

void
add (ll i, ll k)
{
	i++;
	while (i < size)
		arr[i] += k, i += lsb(i);
}

int
main ()
{
	ll n, q, x;
	scanf ("%lld %lld\n", &n, &q);
	
	for (x = 0; x < n + 5; x++) {
		arr[x] = 0;
	}
	
	for (x = 0; x < q; x++) {
		char ch;
		ll i, k;
		scanf ("%c", &ch);
		
		if (ch == '+') {
			scanf ("%lld %lld\n", &i, &k);
			add (i, k);
		} else {
			scanf ("%lld\n", &i);
			printf ("%lld\n", sum (i));
		}
		
	}
	
	return 0;
}