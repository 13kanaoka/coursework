# UTF-8 Encoding:
---
> Name:  {name}
> GitHub Account: {account}

## Questions

### Unicode to UTF-8 ([Encoding](encode_utf8.md))
1. Convert the following Unicode Characters into binary:
   1. U+0920
      - xxxx xxxx xxxx xxxx  <!-- response -->
   1. U+0042
      -   <!-- response -->
   1. U+5555
      -   <!-- response -->

1. Determine the number of bytes needed to encode the following values into UTF-8.
   1. U+0920
      -   <!-- response -->
   1. U+0042
      -   <!-- response -->
   1. U+5555
      -   <!-- response -->

1. Provide the UTF-8 binary encoding for the following values:
   1. U+0920
      - xxxx xxxx xxxx xxxx  <!-- response -->
   1. U+0042
      -   <!-- response -->
   1. U+5555
      -   <!-- response -->

1. Provide the UTF-8 hex encoding for the following values:
   1. U+0920
      - xxxx xxxx xxxx xxxx  <!-- response -->
   1. U+0042
      -   <!-- response -->
   1. U+5555
      -   <!-- response -->

### UTF-8 to Unicode ([Decoding](decode_utf8.md))

Consider the following binary string:
```
01011101111010011010001110110001100001011101000110110010
```

1. Chunk the binary string into bytes:
   -   <!-- response -->
   -   <!-- response -->
   -   <!-- response -->
   -   <!-- response -->
   -   <!-- response -->
   -   <!-- response -->

1. Gather together the bytes needed for each UTF-8 character:
   -   <!-- response -->
   -   <!-- response -->
   -   <!-- response -->

1. Unpack the payload from each of the UTF-8 characters:
   -   <!-- response -->
   -   <!-- response -->
   -   <!-- response -->

1. Decode each of the resulting binary values into hexadecimal:
   -   <!-- response -->
   -   <!-- response -->
   -   <!-- response -->




