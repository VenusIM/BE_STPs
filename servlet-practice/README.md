# ๐ Servlet Practice
> ๊ณ์ฐ๊ธฐ ์๋ธ๋ฆฟ์ ๋ง๋ค์ด ๋ณด๋ฉด์ Servlet, GenericServlet, HttpServlet์ ์ดํดํ๋ค.
<br>

## ๐งฐ Library Usage
- Junit5
  - version 5.9.0
- Jakarta ์์นด๋ฅดํ๋ ์๋ฐ8์์ ํ๋ํฌํฌ๋ ์๋ก์ด ํ๋ซํผ
  - version 10.1.0
- Logback
  - version 1.4.4
  
<br>

## ๐ Study Summary
### ๐ Servlet
#### 1๏ธโฃ Servlet
- ์๋ธ๋ฆฟ ์ปจํ์ด๋๊ฐ ์๋ธ๋ฆฟ ์ธํฐํ์ด์ค์ ์๋ ๋ฉ์๋๋ค์ ํธ์ถํจ
  - ์๋ธ๋ฆฟ ์๋ช์ฃผ๊ธฐ์ ๊ด๋ จ๋ ๋ฉ์๋
    - init(), service(), destroy() ...
  - ์๋ธ๋ฆฟ ๊ธฐํ ๋ฉ์๋
    - getServletConfig(), getServletInfo() ...
- Servlet (Interface)
  - ๋ชจ๋  ๋ฉ์๋ ๊ตฌํ์ด ๊ฐ์ ๋๋ค.
- GenericServlet (Abstract Class)
  - Service๋ง ๊ตฌํํด์ฃผ๋ฉด ๋๋ค.
  - Generic Protocol์ ์ฌ์ฉํ  ์ ์๋ค.
  - Servlet Interface์์ ํ์ํ ๋ฉ์๋๋ง ์ฌ์ ์ํ์ฌ ์ฌ์ฉ๊ฐ๋ฅํ๋ค.
- HttpServlet (Abstract Class)
  - doGet(), doPost(), Service()๋ฅผ ๊ตฌํํ๋ค.
  - Http Protocol๋ง ์ฌ์ฉ๊ฐ๋ฅํ๋ค.
#### 2๏ธโฃ Annotation
- @WebServlet
  - xml๊ธฐ๋ฐ์ผ๋ก servlet mapping์ ์์ฑํ์๋ ๊ฒ์ ์ด๋ธํ์ด์ ๊ธฐ๋ฐ์ผ๋ก ๊ฐํธํ๊ฒ ์์ฑ ๊ฐ๋ฅํ๋ค.
- @SuppressWarnings("serial")
  - private static final long serialVersionUID=1L;
  - ๋ฒ์  ์ฒดํฌ๋ฅผ ์ฌ์ฉํ์ง ์์๋ ์ ์ธํ๋ค.
#### :three: URL ์ธ์ฝ๋ฉ (= ํผ์ผํธ ์ธ์ฝ๋ฉ)
- URL๋ก ์ฌ์ฉํ  ์ ์๋ ๋ฌธ์(์์ฝ์ด, Non-ASCII ๋ฌธ์(ํ๊ธ) ๋ฑ)๋ฅผ ์ฌ์ฉํ  ์ ์๋๋ก ์ธ์ฝ๋ฉํ๋ ๊ฒ์ด๋ค.
- ์ธ์ฝ๋ฉ ๋ ๋ฌธ์๋ triplet(์ธ ๊ฐ๊ฐ ํ ์ธํธ)๋ก ์ธ์ฝ๋ฉ ๋๋ฉฐ ๊ฐ๊ฐ์ % ๋ค์์ ๋ ๊ฐ์ 16์ง์๋ก ํํํ๋ค.
