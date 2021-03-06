#ifndef _FONT_LOAD_H_
#define _FONT_LOAD_H_

typedef struct
{
unsigned char *bmp;
unsigned char *pal;
int w, h, c;
} raw_file;


typedef struct
{
char *name;
char *fpath;
int spacewidth;
int charspace;
int height;
//char *fname_a;
//char *fname_b;
raw_file* pic_a[16];
raw_file* pic_b[16];
short font[65536];
short start[65536];
short width[65536];
double outline_thickness;
double blur_radius;
} font_desc_t;

raw_file* load_raw(char *name,int verbose);
font_desc_t* read_font_desc(char* fname,float factor,int verbose);

#endif /* _FONT_LOAD_H_ */
